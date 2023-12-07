import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ScheduleBlock(BD: NNSBD){
    LazyColumn(Modifier.fillMaxSize()) {
        items(BD.Lessons) { message ->
            day(message)
        }
    }
}

@Composable
fun day(a : Array<MutableState<List<Lesson>>>){
    Row(Modifier.fillMaxWidth()){
        for (i in a){
            classroom(i)
        }
    }
}

@Composable
fun classroom(a : MutableState<List<Lesson>>){
    Column {
        for (i in a.value){
            lesson(i)
        }
    }
}

@Composable
fun lesson(a : Lesson){
    Button(onClick = {}){
        Text(a.name)
    }
}