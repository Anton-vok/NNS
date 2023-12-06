import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun addLesson(BD: NNSBD){

    var name = remember { mutableStateOf("") }
    var teacher= remember { mutableStateOf("") }

    var day = remember { mutableStateOf("") }
    var startOne = remember { mutableStateOf("") }
    var endOne = remember { mutableStateOf("") }
    var startTwo = remember { mutableStateOf("") }
    var endTwo = remember { mutableStateOf("") }

    var lessonOne = remember { mutableStateOf("") }
    var lessonTwo = remember { mutableStateOf("") }

    var focusName =  remember { FocusRequester() }
    var focusTeacher =  remember { FocusRequester() }

    var focusDay =  remember { FocusRequester() }
    var focusStartOne =  remember { FocusRequester() }
    var focusStartTwo =  remember { FocusRequester() }
    var focusEndOne =  remember { FocusRequester() }
    var focusEndTwo =  remember { FocusRequester() }

    var focusLessonOne =  remember { FocusRequester() }
    var focusLessonTwo =  remember { FocusRequester() }

    Column(Modifier.fillMaxSize()){

        Row(
            Modifier.weight(0.1f).wrapContentSize(Alignment.Center)
        ){
            Text(style = textStyle2, text="Добавить урок")
        }

        Row(
            Modifier
                .weight(0.160f)
                .wrapContentSize(Alignment.Center)
        ){
            Column {
                Text("Название урока", style = textStyle3)
                PanelInput(name, focusName, focusTeacher, true)
            }
        }

        Row(
            Modifier
                .weight(0.160f)
                .wrapContentSize(Alignment.Center)
        ){
            Column {
                Text("Учитель", style = textStyle3)
                PanelInput(teacher, focusTeacher, focusDay, true)
            }
        }

        Row(
            Modifier.weight(0.08f).wrapContentSize(Alignment.Center)
        ){
            Text(style = textStyle3, text="Дата и время")
        }


        Row(
            Modifier.weight(0.130f).wrapContentSize(Alignment.Center)
        ){
            Row(Modifier.weight(0.15f).background(PanelOneColor)
            ){
                PanelInput(day, focusDay, focusStartOne, true)
            }

            Row(Modifier.weight(0.125f)){}

            Row(Modifier.weight(0.30f).background(BackgroundTwoColor).border(1.dp, Color(145, 151, 153), shape = RoundedCornerShape(4.dp)).border(1.dp, Color(145, 151, 153), shape = RoundedCornerShape(4.dp))
            ){
                Row(Modifier.weight(0.40f).background(PanelOneColor)){
                    Row(Modifier.weight(0.40f).background(PanelOneColor)){
                        PanelInput(startOne, focusStartOne, focusStartTwo, true)
                    }
                }
                Row(Modifier.weight(0.20f)){}
                Row(Modifier.weight(0.40f).background(PanelOneColor)){
                    PanelInput(startTwo, focusStartTwo, focusEndOne, true)
                }
            }

            Row(Modifier.weight(0.125f)){}

            Row(Modifier.weight(0.30f).background(BackgroundTwoColor).border(1.dp, Color(145, 151, 153), shape = RoundedCornerShape(4.dp)).border(1.dp, Color(145, 151, 153), shape = RoundedCornerShape(4.dp))
            ){
                Row(Modifier.weight(0.40f).background(PanelOneColor)){
                    Row(Modifier.weight(0.40f).background(PanelOneColor)){
                        PanelInput(endOne, focusEndOne, focusEndTwo, true)
                    }
                }
                Row(Modifier.weight(0.20f)){}
                Row(Modifier.weight(0.40f).background(PanelOneColor)){
                    PanelInput(endTwo, focusEndTwo, focusLessonOne, true)
                }
            }
        }

        Row(
            Modifier.weight(0.08f).wrapContentSize(Alignment.Center)
        ){
            Text(style = textStyle3, text="Классы")
        }

        Row(
            Modifier.weight(0.130f).wrapContentSize(Alignment.Center)
        ){
            Row(Modifier.weight(0.4f).wrapContentSize(Alignment.Center)){
                PanelInput(lessonOne, focusLessonOne, focusLessonTwo, true)
            }
            Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){}
            Row(Modifier.weight(0.4f).wrapContentSize(Alignment.Center)){
                 PanelInput(lessonTwo, focusLessonTwo, focusLessonTwo, false)
            }
        }

        Row(
            Modifier.weight(0.16f).wrapContentSize(Alignment.Center)
        ){
            Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){}
            Row(Modifier.weight(0.6f).wrapContentSize(Alignment.Center)) {
                Button(onClick = {
                    BD.add(Lesson(name.value, day.value.toInt(), mutableListOf(lessonOne.value.toInt(), lessonTwo.value.toInt()), teacher.value, startOne.value.toInt()*60+startTwo.value.toInt(), endOne.value.toInt()*60+endTwo.value.toInt()))
                    name.value=""
                    day.value=""
                    lessonOne.value=""
                    lessonTwo.value=""
                    teacher.value=""
                    startOne.value=""
                    startTwo.value=""
                    endOne.value=""
                    endTwo.value=""
                })
                {
                    Text("Сохранить")
                }
            }
            Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){}
        }
    }
}