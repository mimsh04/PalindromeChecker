package no.uio.ifi.in2000.mariish.oblig1

fun isPalindrome(tekst:String):Boolean{
    val tekst=tekst.lowercase()
    return tekst==tekst.reversed()
}
