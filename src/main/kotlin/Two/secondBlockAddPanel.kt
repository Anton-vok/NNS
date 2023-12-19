package Two

import ButtonOneColor
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

@Composable
fun addLesson(BD: NNSBD){

    var state = SecondBlock(BD)

    Column(Modifier.fillMaxSize()){

        Row(Modifier.weight(0.1f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle2, text="Добавить урок")
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
            for (i in 1..4){
                Row(Modifier.weight(0.05f).wrapContentSize(Alignment.Center)){}
                Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){
                    PanelInput(state.lessons[i])
                }
            }
        }

        Row(Modifier.weight(0.160f).wrapContentSize(Alignment.Center)){
            Column(Modifier.fillMaxHeight(0.8f)){
                Row(Modifier.weight(0.1f).wrapContentSize(Alignment.Center)){}
                PanelInput(state.teacher, state.expandedTwo)
                SelectPanel(state.teacher, BD.teachers.value, state.expandedTwo)
                Row(Modifier.weight(0.1f).wrapContentSize(Alignment.Center)){}
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
                Row(Modifier.weight(0.1f)){}
                Row(Modifier.weight(0.8f)) {
                    cosButton(
                        onClick = { state.add() },
                        color = remember { mutableStateOf( ButtonOneColor ) },
                        text = remember { mutableStateOf("Сохранить") },
                        textStyle = textStyle4
                    )
                }
                Row(Modifier.weight(0.1f)){}
            }
            Row(Modifier.fillMaxHeight(0.1f)){}
        }
    }
}