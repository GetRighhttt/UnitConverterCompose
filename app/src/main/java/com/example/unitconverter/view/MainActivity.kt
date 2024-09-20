package com.example.unitconverter.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text("Unit Converter")
                            },
                        )
                    },
                ) { innerPadding ->
                    UnitConverter(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun UnitConverter(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter Demo")

        Spacer(modifier = Modifier.padding(16.dp))

        OutlinedTextField(
            value = "",
            singleLine = true,
            supportingText = {
                Text("Please enter a number to convert...")
            },
            shape = Shapes().medium,
            onValueChange = {
                // Handle input change here
            },
            placeholder = {
                Text(text = "Enter Value:")
            },
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Row(modifier = Modifier) {
            // Necessary context with Jetpack Compose for displaying toast
            val context = LocalContext.current
            Box() {
                Button(onClick = {
                    showToast(context, "Choose Button Clicked!")
                }) {
                    Text("Choose: ")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Drop Down Icon")
                }
                DropdownMenu(
                    expanded = false,
                    onDismissRequest = {
                        // TODO: Handle dismiss request
                    }
                ) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = { /*TODO: On CLick*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = { /*TODO: On CLick*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = { /*TODO: On CLick*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = { /*TODO: On CLick*/ }
                    )
                }
            }

            Spacer(modifier = Modifier.padding(5.dp))

            Box() {
                Button(onClick = {
                    showToast(context, "Convert Button Clicked!")
                }) {
                    Text("Convert To: ")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Drop Down Icon")
                }
                DropdownMenu(
                    expanded = false,
                    onDismissRequest = {
                        // TODO: Handle dismiss request
                    }
                ) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = { /*TODO: On CLick*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = { /*TODO: On CLick*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = { /*TODO: On CLick*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = { /*TODO: On CLick*/ }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Text("Result: ")
    }
}

fun showToast(context: Context, message: String) =
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnitConverter(modifier = Modifier)
}