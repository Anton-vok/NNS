import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup

@Composable
fun PanelInput(endOne: MutableState<String>){
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
fun PanelInputTwo(endOne: MutableState<String>, myFocus: MutableState<Boolean>){
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
            onValueChange = {
                endOne.value = it },
            Modifier
                .align(Alignment.Center)
                .padding(vertical = 8.dp)
                .onFocusChanged {
                    focusState -> FocusDay = focusState.isFocused
                    myFocus.value = focusState.isFocused},
            singleLine = true,
            textStyle = textStyle4
        )

    }
}



@Composable
fun Timing(One: MutableState<String>, Two: MutableState<String>){
    Row(Modifier.fillMaxSize().background(BackgroundTwoColor).border(1.dp, Color(145, 151, 153), shape = RoundedCornerShape(4.dp))
    ){
        Row(Modifier.weight(0.40f).background(PanelOneColor)){
                PanelInput(One)
        }
        Box(Modifier.weight(0.20f).fillMaxHeight(), contentAlignment = Alignment.Center){
            Text(":", style = textStyle3)
        }
        Row(Modifier.weight(0.40f).background(PanelOneColor)){
            PanelInput(Two)
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

@Composable
fun SelectPanel(
    onItemSelected: MutableState<String>,
    allSuggestions: MutableList<String>,
    expanded: MutableState<Boolean>
) {
    Column {
        if (expanded.value) {
            val filteredSuggestions = allSuggestions.filter { it.contains(onItemSelected.value, ignoreCase = true) }
            Popup(
                alignment = Alignment.TopStart,
                onDismissRequest = { expanded.value = false }
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.16f).heightIn(max = 100.dp).background(MaterialTheme.colors.background)
                ) {
                    for (suggestion in filteredSuggestions) {
                        Box(
                            modifier = Modifier.fillMaxWidth()
                                .clickable {
                                    onItemSelected.value = suggestion
                                    expanded.value = false
                                }
                                .padding(8.dp)
                        ) {
                            Text(suggestion)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ColorPicer(color: Color){
    
}