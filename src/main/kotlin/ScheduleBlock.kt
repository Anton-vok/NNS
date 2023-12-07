import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScheduleBlock(BD: NNSBD){
    LazyColumn(Modifier.fillMaxSize()) {
        items(BD.Lessons) { message ->
            day(message)
            Row(Modifier.fillMaxWidth().height(20.dp)){}
        }
    }
}

@Composable
fun day(a : Array<MutableState<List<Lesson>>>){
    Row(Modifier.fillMaxWidth().background(BackgroundOneColor)){
        for (i in a){
            var w=0.7f/NNBD.classroomInt.toFloat()
            var ww=0.3f/NNBD.classroomInt.toFloat()
            Box(Modifier.weight(ww)) {}
            Box(Modifier.weight(w)) {
                classroom(i)
            }
        }
    }
}

@Composable
fun classroom(a : MutableState<List<Lesson>>){
    Column(){
        var time=480
        var height=0
        for (i in a.value){
            if (time<i.timeStart){
                height=i.timeStart-time
                time=i.timeEnd
            } else { height=0 }
            Row(Modifier.fillMaxWidth().height(height.dp)){}
            lesson(i)
        }
    }
}

@Composable
fun lesson(a : Lesson){
    var w=0
    if (a.timeStart>=a.timeEnd){
        w=5
    } else { w=a.timeEnd-a.timeStart }
    Button(
        modifier = Modifier.fillMaxWidth().height(w.dp),
        onClick = {

    }){
        Text(a.name)
    }
}