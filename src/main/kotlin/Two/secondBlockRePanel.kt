package Two

import ButtonOneColor
import ButtonTwoColor
import Lesson
import NNSBD
import PanelInput
import PanelOneColor
import SelectPanel
import Timing
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cosButton
import textStyle2
import textStyle3
import textStyle4
import twoPanelRe

@Composable
fun ReLesson(BD: NNSBD, lesson: Lesson){

    var state = SecondBlock(BD)
    state.importFromLesson(lesson)

    Column(Modifier.fillMaxSize()){

        Row(Modifier.weight(0.1f).wrapContentSize(Alignment.Center)){
            Row(Modifier.fillMaxWidth(0.95f)){ Text(style = textStyle2, text="Редактировать урок") }
            Row(Modifier.fillMaxWidth(1f)){ Button(onClick = { twoPanelRe.value=false }){ Text("X") } }
        }

        Row(Modifier.weight(0.160f).wrapContentSize(Alignment.Center)){
            Column {
                Text("Название урока", style = textStyle3)
                PanelInput(state.name, state.expandedOne)
                SelectPanel(state.name, BD.lessonType.value, state.expandedOne)
            }
        }

        Row(Modifier.weight(0.08f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle3, text="Классы")
        }

        Row(Modifier.weight(0.130f).wrapContentSize(Alignment.Center)){
            for (i in 0..3){
                Row(Modifier.weight(0.05f).wrapContentSize(Alignment.Center)){}
                Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){
                    PanelInput(state.lessons[i])
                }
            }
        }

        Row(Modifier.weight(0.160f).wrapContentSize(Alignment.Center)){
            Column {
                Text("Учитель", style = textStyle3)
// TODO
                PanelInput(state.teacher, state.expandedTwo)
                SelectPanel(state.teacher, BD.teachers.value, state.expandedTwo)
            }
        }

        Row(Modifier.weight(0.08f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle3, text="Дата и время")
        }

        Row(Modifier.weight(0.130f).wrapContentSize(Alignment.Center)){
            Row(Modifier.weight(0.15f).background(PanelOneColor)){ PanelInput(state.day) }
            Row(Modifier.weight(0.125f)){}
            Row(Modifier.weight(0.30f)){ Timing(state.startOne, state.startTwo) }
            Row(Modifier.weight(0.125f)){}
            Row(Modifier.weight(0.30f)){ Timing(state.endOne, state.endTwo) }
        }

        Column (Modifier.weight(0.16f).wrapContentSize(Alignment.Center)) {
            Row(Modifier.fillMaxHeight(0.1f)){}
            Row(Modifier.fillMaxHeight(0.8f)) {
                Row(Modifier.fillMaxWidth(0.45f)) {
                    cosButton(
                        onClick = {state.edit(lesson)},
                        color = remember { mutableStateOf(ButtonOneColor) },
                        text = remember { mutableStateOf("Edit") },
                        textStyle = textStyle4
                        )
                }
                Row(Modifier.fillMaxWidth(0.1f)) {}
                Row(Modifier.fillMaxWidth()) {
                    cosButton(
                        onClick = {state.del(lesson)},
                        color = remember { mutableStateOf(ButtonTwoColor) },
                        text = remember { mutableStateOf("Del") },
                        textStyle = textStyle4
                    )
                }
            }
    Row(Modifier.fillMaxHeight(0.1f)){}
        }
    }
}