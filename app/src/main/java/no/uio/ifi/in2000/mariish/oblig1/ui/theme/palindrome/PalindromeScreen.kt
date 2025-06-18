package no.uio.ifi.in2000.mariish.oblig1.ui.theme.palindrome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun palindromeScreen(navController: NavController) {

    PalindromeChecker()

    Column(
        Modifier.fillMaxSize(),
    )
    {

        Box(
            modifier=Modifier
                .fillMaxSize()
        )
        {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                colors= ButtonDefaults.buttonColors(containerColor = Color.Red),
                onClick = {
                    navController.navigate("unitconverter")
                },
                enabled = true
            )
            {
                Text(text = "Go to UnitConverter")
            }
        }
    }
}




