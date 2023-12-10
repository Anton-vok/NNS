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

    var expandedTwo = remember { mutableStateOf(false) }
    var expandedOne = remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize()){

        Row(Modifier.weight(0.1f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle2, text="Добавить урок")
        }

        Row(Modifier.weight(0.160f).wrapContentSize(Alignment.Center)){
            Column {
                Text("Название урока", style = textStyle3)
                PanelInputTwo(name, expandedOne)
                SelectPanel(name, BD.lessonsType, expandedOne)
            }
        }

        Row(Modifier.weight(0.08f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle3, text="Классы")
        }

        Row(Modifier.weight(0.130f).wrapContentSize(Alignment.Center)){
            Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){
                PanelInput(lessonOne)
            }
            Row(Modifier.weight(0.05f).wrapContentSize(Alignment.Center)){}
            Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){
                PanelInput(lessonTwo)
            }
            Row(Modifier.weight(0.05f).wrapContentSize(Alignment.Center)){}
            Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){
                PanelInput(lessonThree)
            }
            Row(Modifier.weight(0.05f).wrapContentSize(Alignment.Center)){}
            Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){
                PanelInput(lessonFour)
            }
        }

        Row(Modifier.weight(0.160f).wrapContentSize(Alignment.Center)){
            Column {
                Text("Учитель", style = textStyle3)
                PanelInputTwo(teacher, expandedTwo)
                SelectPanel(teacher, BD.teacher, expandedTwo)
            }
        }

        Row(Modifier.weight(0.08f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle3, text="Дата и время")
        }

        Row(Modifier.weight(0.130f).wrapContentSize(Alignment.Center)){
            Row(Modifier.weight(0.15f).background(PanelOneColor)){ PanelInput(day) }
            Row(Modifier.weight(0.125f)){}
            Row(Modifier.weight(0.30f)){ Timing(startOne, startTwo) }
            Row(Modifier.weight(0.125f)){}
            Row(Modifier.weight(0.30f)){ Timing(endOne, endTwo) }
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