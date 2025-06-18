package no.uio.ifi.in2000.mariish.oblig1

import kotlin.math.roundToInt


fun converter(verdi:Int,enhet:ConverterUnits):Int{
    val enhet=enhet
    val mengde=verdi

    when(enhet){
        ConverterUnits.OUNCE->return (mengde*0.02957).roundToInt()
        ConverterUnits.CUP->return (mengde*0.23659).roundToInt()
        ConverterUnits.GALLON->return (mengde*3.78541).roundToInt()
        ConverterUnits.HOGSHEAD->return (mengde*238.481).roundToInt()


    }

}