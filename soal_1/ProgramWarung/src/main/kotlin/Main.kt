
fun main() {
    print("Masukan Nama Kasir : ")
    val name = readLine()
    var menu : ArrayList<String> = arrayListOf()
    var price : ArrayList<Int> = arrayListOf()
    inputMenu(menu, price)
    println()

    if (name != null) {
        header(name)
    }
    var total = 0
    for (i in 0..menu.size-1) {
        println("\n" + textLayout(menu[i], "Rp.${price[i]}", 30, '.'))
        total += price[i]
        if (i==menu.size-1) {
            println("\n\n" + textLayout("Total", "Rp.$total", 30, '.'))
        }
    }

}

fun inputMenu( menu: ArrayList<String>, price: ArrayList<Int>) {
    print("Masukan Menu : ")
    var food = readLine()
    if (food != null) {
        menu.add(food)
    }

    print("Masukan Harga : ")
    var priceFood = readLine()
    if (priceFood != null) {
        price.add(priceFood.toInt())
    }
    print("Apakah ingin masukan data lagi?(Y/N) ")
    var confirm = readLine()?.toLowerCase()
    if (confirm == "y" || confirm == "ya" ) {
        inputMenu(menu, price)
    }
}
fun alignCenter(text: String, width: Int): String {
    val widthText = text.length
    val countBlank = (width - widthText) / 2
    var blank : String = ""

    for (i in 1..countBlank){
        blank += " "
    }

    return "$blank$text$blank"
}
fun header(name: String){
    val title = "Warung Makan Sederhana"
    var formatted = DateNow("yyyy/MM/dd HH:mm:ss")

    println(alignCenter(title, 30))
    println()
    println(textLayout("Tanggal : ", formatted.now, 30, ' '))
    println()
    println(textLayout("Nama Kasir : ", name, 30, ' '))
    println()
    for (line in 1..30) print("=")
    println()
}
fun textLayout(left: String, right: String, width: Int, blank_char: Char) : String {
    val countLeft = left.length
    val countRight = right.length
    var textLeft = ""
    var countBlank : Int
    if (countLeft>width-15) {
        var textLeftSplit = left.split("")
        for (a in 0..14) {
            textLeft +=textLeftSplit[a]
        }
        countBlank = 30 - textLeft.length
    } else {
        textLeft = left
        countBlank = 30 - textLeft.length
    }
    countBlank -= countRight
    var blank : String = ""
    for (space in 1..countBlank) {
        blank += blank_char
    }
   return "$textLeft$blank$right"

}