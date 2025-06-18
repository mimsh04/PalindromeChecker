package no.uio.ifi.in2000.mariish.oblig1.ui.theme.unitconverter

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import no.uio.ifi.in2000.mariish.oblig1.ConverterUnits
import no.uio.ifi.in2000.mariish.oblig1.converter


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun UnitConverter() {
    var verdi by remember { mutableIntStateOf(0) }
    val keyboardController = LocalSoftwareKeyboardController.current

    val options: List<ConverterUnits> = ConverterUnits.entries.toList()
    var expanded by remember { mutableStateOf(false) }
    val textFieldState = rememberTextFieldState(ConverterUnits.OUNCE.toString())
    var enhet by remember { mutableStateOf(ConverterUnits.OUNCE) }

    var resultat=0


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            text="UnitConverter",
            modifier=Modifier
                .padding(50.dp),
            style= TextStyle(fontSize=30.sp,fontWeight= FontWeight.Bold),
            color= Color.Blue
        )


        //kun tillatt med tall, 0 er default
        TextField(
            value = verdi.toString(),
            onValueChange = {
                if(it.isBlank()){
                    verdi=0
                }
                else if(it.toIntOrNull()==null || it.toInt()>Int.MAX_VALUE){
                    verdi=0
                }
                else{
                    verdi=it.toInt()
                    resultat = converter(verdi, enhet)

                }


            },
            label = { Text("Write in a number") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            )
        )

        Spacer(modifier=Modifier.height(16.dp))


        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it }

            )
        {
            TextField(
                value = textFieldState.text.toString(),
                onValueChange = { },
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded=expanded) },
                modifier=Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            )
            {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option.toString()) },
                        onClick = {
                            textFieldState.setTextAndPlaceCursorAtEnd(option.toString())
                            expanded = false
                            enhet=option
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }

            }


        }

        Spacer(modifier=Modifier.height(16.dp))


        resultat = converter(verdi, enhet)
        Text(
            text="$verdi $enhet er $resultat liter",
                    modifier=Modifier
                    .padding(30.dp),
            style=TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )


    }

}
