import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.jetbrains.skia.Color

class Lesson(nName: String, nDay: Int, nClassRoom: MutableList<Int>, nTeacher: String, nTimeStart: Int, nTimeEnd: Int){
    var name=nName
    var day=nDay
    var classRoom=nClassRoom
    var teacher=nTeacher

    var timeStart=nTimeStart
    var timeEnd=nTimeEnd

    var color= Color.WHITE
}
class NNSBD(day: Int, classroom: Int){
    var Lessons = Array<Array<MutableState<List<Lesson>>>> (day) { Array<MutableState<List<Lesson>>> (classroom) {mutableStateOf( listOf<Lesson>() ) } }
    fun add(lesson: Lesson){
        var day=lesson.day-1
        for (i in lesson.classRoom){
            Lessons[day][i-1].value=Lessons[day][i-1].value+lesson
        }
    }
}