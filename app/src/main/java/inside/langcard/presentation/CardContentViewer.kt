package inside.langcard.presentation

import android.app.Activity
import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.LinearLayout
import com.svp.infrastructure.common.ViewExtensions
import com.svp.infrastructure.common.view.ListViewEx
import inside.langcard.R
import inside.langcard.domain.model.CardModel
import inside.langcard.domain.model.SideTypes
import inside.langcard.presentation.Dialog.CardColorProvider


/**
 * Created by Pasha on 2/5/2018.
 */
class ContentViewer(private val activity: Activity){
    interface OnCardListener {
        fun onClick(card: CardModel)
    }
    inner class OnClickListener(private val card: CardModel,private val  listener : OnCardListener) : View.OnClickListener, AdapterView.OnItemClickListener {
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            listener.onClick(card)
        }

        override fun onClick(v: View) {
            listener.onClick(card)
        }
    }

    lateinit var listener : OnCardListener

    lateinit var cards : List<CardModel>
    var columns : Int = 1

    val inflater : LayoutInflater = activity.layoutInflater
    val container : ViewGroup = activity.window.decorView as ViewGroup
    val rootView : View = activity.findViewById(android.R.id.content)

    lateinit var layouts : MutableList<LinearLayout>
    lateinit var map : MutableMap<String,View>

    fun onCreateView(cards : List<CardModel>, columns : Int, listener : OnCardListener) : View {
        this.cards = cards
        this.columns = columns
        this.listener = listener

        updateColumns(columns)

        search("")

        val sv = getScrollView(rootView)
        sv.post({
            fun run() {
                //TODO: get scroll position from local storage
                val pos = 0
                sv.scrollTo(0,pos)
            }
        })

        //TODO: activity.updateTitle();
        return rootView
    }

    fun updateColumns( columns : Int){
        this.columns = columns

        val halfScreenWidth = getScreenWidth() / columns
        val root = ViewExtensions.findViewById<GridLayout>(rootView, R.id.rootLayout)

        layouts = MutableList(columns){
            index -> createLinearLayout(root, index, halfScreenWidth)
        }
    }

    fun search(query:String){
        layouts.forEach { it.removeAllViews() }

        map = hashMapOf()
        val pr = CardColorProvider()

        var index = 0
        cards.forEach {
            val text1 = it.getLearningText(SideTypes.Back)
            val text2 = it.getLearningText(SideTypes.Front)

            val ordered = text1.contains(query) && text2.contains(query)
            if(query == "" || ordered){
                index++
                val item = inflater.inflate(R.layout.card_item_mainlist_template, container, false)
                item.findViewById<View>(R.id.ticket_item_container)
                    .setBackgroundColor(pr.getColorIntBackground(it.getBackground()))
                item.setOnClickListener(OnClickListener(it,listener))

                //adapter for list of words for one ticket
                val adapter = ArrayAdapter<String>(inflater.context,
                        R.layout.card_word_item_tempate,
                        it.getDisplayLearningText())

                val list = ViewExtensions.findViewById<ListView>(item, R.id.learning_listOfFirst)
                list.adapter = adapter
                list.onItemClickListener = OnClickListener(it,listener)

                ViewExtensions.findViewById<TextView>(item, R.id.ticket_item_langs).text =getLangFormatString(it)

                ListViewEx.setHeightListView(list, adapter)
                //separate tickets by 2 columns
                layouts[index % columns].addView(item)
                map.put(it.id, item)
            }
        }

    }

    fun updateItemView(card : CardModel){
        map[card.id]?.let {
                val adapter = ArrayAdapter<String>(inflater.context,
                        R.layout.card_word_item_tempate,
                        card.getDisplayLearningText())
                val list = ViewExtensions.findViewById<ListView>(it, R.id.learning_listOfFirst)
                list.adapter = adapter
                list.onItemClickListener = OnClickListener(card,listener)

                ViewExtensions.findViewById<TextView>(it, R.id.ticket_item_langs).text = getLangFormatString(card)
                ListViewEx.setHeightListView(list, adapter)
        }
    }

    private fun getLangFormatString(card: CardModel): String {
        return card.getLanguage(card.sideType).getTitle().toLowerCase() + " / " +
                card.getLanguage(card.getInvertOfCurrentSideType()).getTitle().toLowerCase()
    }

    private fun createLinearLayout(root : GridLayout,index:Int,width:Int) : LinearLayout{
        val col = LinearLayout(inflater.context)
        col.orientation = LinearLayout.VERTICAL
        col.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        val param = GridLayout.LayoutParams(GridLayout.spec(0), GridLayout.spec(index))
        param.width = width
        root.addView(col, param)

        return col
    }


    private fun getScreenSize(): Point {
        val size = Point()
        activity.windowManager.defaultDisplay.getSize(size)
        return size
    }
    private fun getScreenWidth(): Int {
        return getScreenSize().x
    }
    fun getScrollView(rootView:View):ScrollView{
        return ViewExtensions.findViewById<ScrollView>(rootView, R.id.root_scrollview)
    }

}