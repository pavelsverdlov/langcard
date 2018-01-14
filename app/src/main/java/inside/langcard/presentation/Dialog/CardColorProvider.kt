package inside.langcard.presentation.Dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.design.widget.CoordinatorLayout
import inside.langcard.R

/**
 * Created by Maxim on 12/10/2017.
 */
open class CardColorProvider{
    fun getDrawableSecondBackground (color:CardColors): Drawable{
        return ColorDrawable(getColorIntSecondBackground(color))
    }

     fun getColorIntSecondBackground(color: CardColors): Int {

        val icolor:Int
        when(color){
            CardColors.Blue -> icolor = Color.parseColor("#2196F3")
            CardColors.Yellow -> icolor = Color.parseColor("#FF9800")
            CardColors.Green -> icolor = Color.parseColor("#4CAF50")
            CardColors.Red -> icolor = Color.parseColor("#F44336")
            CardColors.Violet -> icolor = Color.parseColor("#9C27B0")
            CardColors.White -> icolor = Color.parseColor("#CCCCCC")
            CardColors.DeepOrange -> icolor = Color.parseColor("#FF5722")
            CardColors.Indigo -> icolor = Color.parseColor("#3F51B5")
            CardColors.DeepPurple -> icolor = Color.parseColor("#673AB7")
            CardColors.Lime -> icolor = Color.parseColor("#CDDC39")
            CardColors.Cyan -> icolor = Color.parseColor("#00BCD4")
            CardColors.Brown -> icolor = Color.parseColor("#795548")
            CardColors.Grey -> icolor = Color.parseColor("#9E9E9E")
            CardColors.Pink -> icolor = Color.parseColor("#E91E63")

        }
        return icolor
    }

    fun getDrawableBackground(color: CardColors): Drawable{
        return ColorDrawable(getColorIntBackground(color))
    }

    fun getColorIntBackground(color: CardColors): Int{
        when (color){
            CardColors.Blue -> return Color.parseColor("#42A5F5")
            CardColors.Yellow -> return Color.parseColor("#FFA726")
            CardColors.Green -> return Color.parseColor("#66BB6A")
            CardColors.Red -> return Color.parseColor("#EF5350")
            CardColors.Violet -> return Color.parseColor("#AB47BC")
            CardColors.White -> return Color.parseColor("#FFFFFF")
            CardColors.Pink -> return Color.parseColor("#EC407A")
            CardColors.DeepPurple -> return Color.parseColor("#7E57C2")
            CardColors.Indigo -> return Color.parseColor("#5C6BC0")
            CardColors.Cyan -> return Color.parseColor("#26C6DA")
            CardColors.Lime -> return Color.parseColor("#D4E157")
            CardColors.DeepOrange -> return Color.parseColor("#FF7043")
            CardColors.Brown -> return Color.parseColor("#8D6E63")
            CardColors.Grey -> return Color.parseColor("#BDBDBD")
        }
    }

    fun getDrawableBackgroundId(color: CardColors): Int{
        when(color){
            CardColors.Blue -> return R.drawable.ticket_background_blue
            CardColors.Yellow -> return R.drawable.ticket_background_yellow
            CardColors.Green -> return R.drawable.ticket_background_green
            CardColors.Red -> return R.drawable.ticket_background_red
            CardColors.Violet -> return R.drawable.ticket_background_violet
            CardColors.White -> return R.drawable.ticket_background_white
            CardColors.Pink -> return R.drawable.ticket_background_pink
            CardColors.DeepPurple -> return R.drawable.ticket_background_deeppurple
            CardColors.Indigo -> return R.drawable.ticket_background_indigo
            CardColors.Cyan -> return R.drawable.ticket_background_indigo
            CardColors.Lime -> return R.drawable.ticket_background_lime
            CardColors.DeepOrange -> return R.drawable.ticket_background_deeporange
            CardColors.Brown -> return R.drawable.ticket_background_brown
            CardColors.Grey -> return R.drawable.ticket_background_gray
        }
    }
}