package ro.pub.cs.systems.eim.practicaltest01var04

import android.R
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ro.pub.cs.systems.eim.practicaltest01var04.ui.theme.PracticalTest01Var04Theme

class PracticalTest01Var04SecondaryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nume = intent.getStringExtra("nume").orEmpty()
        val grupa = intent.getStringExtra("grupa").orEmpty()

        setContent {
            PracticalTest01Var04Theme {
                SecondScreen(nume, grupa)
            }
        }
    }
}

@Composable
private fun SecondScreen(nume: String, grupa: String) {

    val context = LocalContext.current;
    val activity = context as Activity

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(nume)

        Text(grupa)

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {
                Toast.makeText(activity, "OK", Toast.LENGTH_SHORT).show()
                activity.finish()
            }) { Text("OK") }

            Button(onClick = {
                Toast.makeText(activity, "Cancel", Toast.LENGTH_SHORT).show()
                activity.finish()
            }) { Text("Cancel") }
        }
    }
}