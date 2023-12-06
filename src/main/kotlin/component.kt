import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PanelInput(endOne: MutableState<String>, myFocus: FocusRequester, themFocus: FocusRequester, request: Boolean){
    var FocusDay by remember { mutableStateOf(false) }
    var colorDay=if(FocusDay) Color(115, 32, 239) else Color(145, 151, 153)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(1.dp, colorDay, shape = RoundedCornerShape(4.dp))
        ) {
            BasicTextField(
                value = endOne.value,
                onValueChange = { endOne.value = it },
                Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 8.dp)
                    .onFocusChanged { focusState ->
                        FocusDay = focusState.isFocused
                    }
//                    .onKeyEvent {
//                        if (it.key == Key.Enter && request){
//                            runBlocking {
//                                delay(1000)
//                                themFocus.requestFocus()
//                                true
//                            }
//                        } else {
//                            false}
//                    }
//                    .focusRequester(myFocus)
                    ,
                singleLine = true,
                textStyle = textStyle4
            )

    }
}