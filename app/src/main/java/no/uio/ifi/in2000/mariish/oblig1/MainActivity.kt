package no.uio.ifi.in2000.mariish.oblig1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.mariish.oblig1.ui.theme.Mariish_oblig1Theme
import no.uio.ifi.in2000.mariish.oblig1.ui.theme.palindrome.PalindromeChecker
import no.uio.ifi.in2000.mariish.oblig1.ui.theme.palindrome.palindromeScreen
import no.uio.ifi.in2000.mariish.oblig1.ui.theme.unitconverter.UnitConverter
import no.uio.ifi.in2000.mariish.oblig1.ui.theme.unitconverter.unitConverterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mariish_oblig1Theme {
               val navController= rememberNavController()
                NavHost(
                    navController=navController,
                    startDestination = "palindrome",

                )
                {
                    composable("palindrome"){ palindromeScreen(navController) }
                    composable("unitconverter"){ unitConverterScreen(navController) }
                }

            }
        }
    }
}


