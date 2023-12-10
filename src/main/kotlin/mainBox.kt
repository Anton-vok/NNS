import One.ScheduleBlock
import Two.ReLesson
import Two.TeacherPanel
import Two.addLesson
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

var twoPanelRe = mutableStateOf(false)
var twoPanelReVale = mutableStateOf(Lesson("",1, mutableListOf(1), "", 1, 1))


@Composable
fun mainBox(){
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(PanelOneColor)
    ){
        segmentOne()
        Row(Modifier.fillMaxWidth().fillMaxHeight(1f)){
            segmentTwo()
            segmentThree()
            segmentFour()
        }
    }
}

@Composable
fun segmentOne(){
    Row(Modifier
        .fillMaxHeight(0.6f)
        .background(BackgroundTwoColor)

    ){
        ScheduleBlock(NNBD)
    }
}

@Composable
fun segmentTwo() {
    Row(
        Modifier
            .fillMaxWidth(0.18f)
            .background(BackgroundOneColor)
    ) {
        Box(Modifier.fillMaxWidth(0.04f)){}
        Box(Modifier.fillMaxWidth(0.95f)) {
            if (twoPanelRe.value){ ReLesson(NNBD, twoPanelReVale.value) }else{ addLesson(NNBD) }
        }
        Box(Modifier.fillMaxWidth(0.01f)){}
    }
}

@Composable
fun segmentThree(){
    Row(Modifier
        .fillMaxHeight()
        .fillMaxWidth(0.92f)
        .background(BackgroundOneColor)
    ){
        TeacherPanel(NNBD)
    }
}

@Composable
fun segmentFour(){
    Row(Modifier
        .fillMaxHeight(1f)
        .fillMaxWidth()
        .background(BackgroundOneColor)
    ){

    }
}