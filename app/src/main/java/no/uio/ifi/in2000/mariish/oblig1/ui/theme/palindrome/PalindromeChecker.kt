package no.uio.ifi.in2000.mariish.oblig1.ui.theme.palindrome


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import no.uio.ifi.in2000.mariish.oblig1.isPalindrome

@Composable
fun PalindromeChecker(){
    var tekst by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val keyboardController= LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement= Arrangement.Center

    )
    {

        Text(
            text="Is it a Palindrome?",
            modifier=Modifier
                .padding(50.dp),
            style= TextStyle(fontSize=30.sp,fontWeight= FontWeight.Bold),
            color=Color.Blue
        )

        TextField(
            value=tekst,
            onValueChange={tekst=it},
            label={Text("Input text here")},
            singleLine=true,
            keyboardOptions= KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions= KeyboardActions(
                onDone={
                    keyboardController?.hide()
                    result=if (isPalindrome(tekst)) "It's a Palindrome!" else "It's not a Palindrome:("

                }
            )
        )

        Spacer(modifier=Modifier.height(16.dp))

        Button(
            modifier=Modifier
                .height(50.dp)
                .width(140.dp),
            colors=ButtonDefaults.buttonColors(containerColor = Color.Red),
            enabled=true,
            onClick={
                keyboardController?.hide()
                result=if (isPalindrome(tekst)) "It's a Palindrome!" else "It's not a Palindrome!"

            }

        ){
            Text(text="Click on me")

        }

        Text(
            modifier=Modifier
                .padding(30.dp),
            style=TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            text=result
        )


    }







}