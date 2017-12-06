package inside.langcard.presentation.Dialog

/**
 * Created by Maxim on 12/4/2017.
 */
enum class CardColors(val code:Int) {
    Blue (1),
    Yellow(2),
    Green(3),
    Red(4),
    Violet(5),
    White(6),
    Pink(7),
    DeepPurple(8),
    Indigo(9),
    Cyan(10),
    Lime(11),
    DeepOrange(12),
    Brown(13),
    Grey(14);

    fun toInt():Int {return code}
    fun fromInt(i:Int): CardColors{
        when(i){
            1 -> return Blue
            2 -> return Yellow
            3-> return Green
            4-> return Red
            5-> return Violet
            6 -> return White
            7-> return Pink
            8-> return DeepPurple
            9-> return Indigo
            10-> return Cyan
            11-> return Lime
            12-> return DeepOrange
            13-> return Brown
            14-> return Grey
        }
        return White
    }


}