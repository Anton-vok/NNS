import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PanelInput(endOne: MutableState<String>, myFocus: FocusRequester){
    var FocusDay by remember { mutableStateOf(false) }
    var colorDay=if(FocusDay) Color(115, 32, 239) else Color(145, 151, 153)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(1.dp, colorDay, shape = RoundedCornerShape(4.dp))
                .background(PanelOneColor)
        ) {
            BasicTextField(
                value = endOne.value,
                onValueChange = { endOne.value = it },
                Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 8.dp)
                    .onFocusChanged { focusState -> FocusDay = focusState.isFocused },
                singleLine = true,
                textStyle = textStyle4
            )

    }
}



@Composable
fun Timing(One: MutableState<String>, focusOne: FocusRequester, Two: MutableState<String>, focusTwo: FocusRequester){
    Row(Modifier.fillMaxSize().background(BackgroundTwoColor).border(1.dp, Color(145, 151, 153), shape = RoundedCornerShape(4.dp))
    ){
        Row(Modifier.weight(0.40f).background(PanelOneColor)){
                PanelInput(One, focusOne)
        }
        Box(Modifier.weight(0.20f).fillMaxHeight(), contentAlignment = Alignment.Center){
            Text(":", style = textStyle3)
        }
        Row(Modifier.weight(0.40f).background(PanelOneColor)){
            PanelInput(Two, focusTwo)
        }
    }
}

@Composable
fun addButton(BD: NNSBD, name: MutableState<String>, day: MutableState<String>, lessons: List<MutableState<String>>, teacher: MutableState<String>, startOne: MutableState<String>, startTwo: MutableState<String>, endOne: MutableState<String>, endTwo: MutableState<String>){
    Surface(
        modifier = Modifier
            .fillMaxSize(1f)
            .clickable(onClick = {
                var classrooms= mutableListOf<Int>()
                for (i in lessons){
                    if (i.value!=""){
                        classrooms.add(i.value.toInt())
                    }
                }
                if (name.value!="" &&
                    day.value.toIntOrNull()!=null &&
                    !classrooms.isEmpty() &&
                    teacher.value!="" &&
                    startOne.value.toIntOrNull()!=null &&
                    startTwo.value.toIntOrNull()!=null &&
                    endOne.value.toIntOrNull()!=null &&
                    endTwo.value.toIntOrNull()!=null

                ) {
                    BD.add(
                        Lesson(
                            name.value,
                            day.value.toInt(),
                            classrooms,
                            teacher.value,
                            startOne.value.toInt() * 60 + startTwo.value.toInt(),
                            endOne.value.toInt() * 60 + endTwo.value.toInt()
                        )
                    )
                    name.value = ""
                    day.value = ""
                    for (i in lessons){
                        i.value=""
                    }
                    teacher.value = ""
                    startOne.value = ""
                    startTwo.value = ""
                    endOne.value = ""
                    endTwo.value = ""
                }
            }),
        color = ButtonOneColor,
        contentColor = Color.White,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center) {
            Text("Сохранить")
        }
    }
}