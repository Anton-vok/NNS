import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester

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
    var lessonThree = remember { mutableStateOf("") }
    var lessonFour = remember { mutableStateOf("") }


    var focusName =  remember { FocusRequester() }
    var focusTeacher =  remember { FocusRequester() }

    var focusDay =  remember { FocusRequester() }
    var focusStartOne =  remember { FocusRequester() }
    var focusStartTwo =  remember { FocusRequester() }
    var focusEndOne =  remember { FocusRequester() }
    var focusEndTwo =  remember { FocusRequester() }

    var focusLessonOne =  remember { FocusRequester() }
    var focusLessonTwo =  remember { FocusRequester() }
    var focusLessonThree =  remember { FocusRequester() }
    var focusLessonFour =  remember { FocusRequester() }

    Column(Modifier.fillMaxSize()){

        Row(Modifier.weight(0.1f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle2, text="Добавить урок")
        }

        Row(Modifier.weight(0.160f).wrapContentSize(Alignment.Center)){
            Column {
                Text("Название урока", style = textStyle3)
                PanelInput(name, focusName)
            }
        }

        Row(Modifier.weight(0.160f).wrapContentSize(Alignment.Center)){
            Column {
                Text("Учитель", style = textStyle3)
                PanelInput(teacher, focusTeacher)
            }
        }

        Row(Modifier.weight(0.08f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle3, text="Дата и время")
        }

        Row(Modifier.weight(0.130f).wrapContentSize(Alignment.Center)){
            Row(Modifier.weight(0.15f).background(PanelOneColor)){ PanelInput(day, focusDay) }
            Row(Modifier.weight(0.125f)){}
            Row(Modifier.weight(0.30f)){ Timing(startOne, focusStartOne, startTwo, focusStartTwo) }
            Row(Modifier.weight(0.125f)){}
            Row(Modifier.weight(0.30f)){ Timing(endOne, focusEndOne, endTwo, focusEndTwo) }
        }

        Row(Modifier.weight(0.08f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle3, text="Классы")
        }

        Row(Modifier.weight(0.130f).wrapContentSize(Alignment.Center)){
            Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){
                PanelInput(lessonOne, focusLessonOne)
            }
            Row(Modifier.weight(0.05f).wrapContentSize(Alignment.Center)){}
            Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){
                 PanelInput(lessonTwo, focusLessonTwo)
            }
            Row(Modifier.weight(0.05f).wrapContentSize(Alignment.Center)){}
            Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){
                PanelInput(lessonThree, focusLessonThree)
            }
            Row(Modifier.weight(0.05f).wrapContentSize(Alignment.Center)){}
            Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){
                PanelInput(lessonFour, focusLessonFour)
            }
        }

        Column (Modifier.weight(0.16f).wrapContentSize(Alignment.Center)) {
            Row(Modifier.fillMaxHeight(0.1f)){}
            Row(Modifier.fillMaxHeight(0.8f)) {
                Row(Modifier.weight(0.1f)){}
                Row(Modifier.weight(0.8f)) {
                    addButton(BD, name, day, listOf(lessonOne, lessonTwo, lessonThree, lessonFour), teacher, startOne, startTwo, endOne, endTwo)
                }
                Row(Modifier.weight(0.1f)){}
            }
            Row(Modifier.fillMaxHeight(0.1f)){}
        }
    }
}