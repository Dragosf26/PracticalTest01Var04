package ro.pub.cs.systems.eim.practicaltest01var04

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ro.pub.cs.systems.eim.practicaltest01var04.ui.theme.PracticalTest01Var04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticalTest01Var04Theme {
                Main()
            }
        }
    }
}

@Composable
fun Main() {
    var text1 by remember { mutableStateOf("") }
    var text2 by rememberSaveable { mutableStateOf("") }
    var text3 by rememberSaveable { mutableStateOf("") }

    var checked1 by remember { mutableStateOf(true) }
    var checked2 by remember { mutableStateOf(true) }

    val context = LocalContext.current;
    val activity = context as Activity



    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(Modifier.fillMaxWidth()) {
            Button(onClick = {
            }) { Text("NAVIGATE TO SECONDARY ACTIVITY") }
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Checkbox(
                checked = checked1,
                onCheckedChange = { checked1 = it }
            )
            TextField(
                value = text1,
                onValueChange = { text1 = it },
                label = { Text("Introdu textul") },
                singleLine = true,
                modifier = Modifier.weight(1f)
            )
        }


        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Checkbox(
                checked = checked2,
                onCheckedChange = { checked2 = it }
            )
            TextField(
                value = text2,
                onValueChange = { text2 = it },
                label = { Text("Introdu textul") },
                singleLine = true,
                modifier = Modifier.weight(1f)
            )
        }

        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Button(onClick = {
                if ((checked1 && text1.isEmpty()) || (checked2 && text2.isEmpty())) {
                    Toast.makeText(activity, "Eroare", Toast.LENGTH_SHORT).show()
                } else {
                    text3 = "$text1 $text2"
                }
            }) { Text("Display information") }
        }

        Text(text3)
    }
}