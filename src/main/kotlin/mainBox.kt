import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun mainBox(){
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(PanelOneColor)
    ){
        segmentOne()
        Row(Modifier){
            segmentTwo()
            segmentThree()
            segmentFour()
        }
    }
}

@Composable
fun segmentOne(){
    Box(Modifier
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
        Box(
            Modifier.fillMaxWidth(0.95f)
        ) {
            addLesson(NNBD)
        }
        Box(Modifier.fillMaxWidth(0.01f)){}
    }
}

@Composable
fun segmentThree(){
    Box(Modifier
        .fillMaxHeight(1f)
        .fillMaxWidth(0.74f)
        .background(BackgroundOneColor)
    ){


    }
}

@Composable
fun segmentFour(){
    Box(Modifier
        .fillMaxHeight(1f)
        .fillMaxWidth(0.08f)
        .background(BackgroundOneColor)
    ){

    }
}