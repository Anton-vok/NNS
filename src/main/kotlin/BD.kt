import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

interface ToSelectPanel{
    var name: String
}

class Teacher(nName: String) : ToSelectPanel {
    override var name=nName
}

class Lesson(nName: String, nDay: Int, nClassRoom: MutableList<Int>, nTeacher: String, nTimeStart: Int, nTimeEnd: Int){
    var name=nName
    var day=nDay
    var classRoom=nClassRoom
    var teacher=nTeacher

    var timeStart=nTimeStart
    var timeEnd=nTimeEnd

    var color= ButtonOneColor
}

class LessonType(nTeacherList: Array<Teacher>, nName : String) : ToSelectPanel {
    override var name = nName
    var teacherList = nTeacherList
}

class NNSBD(day: Int, classroom: Int){

    var classroomInt=classroom

    var allLesson = mutableListOf<Lesson>()
    var Schedule = Array<Array<MutableState<List<Lesson>>>> (day) { Array<MutableState<List<Lesson>>> (classroom) {mutableStateOf( listOf<Lesson>() ) } }
    var lessonType = mutableListOf<LessonType>()
    var teachers = mutableListOf<Teacher>()

    var oldLessonsType= mutableListOf<String>("Физика", "Математика", "Русский")
    var oldTeacher= mutableListOf<String>("Андрей", "Илья", "Паша")

    fun add(lesson: Lesson){
        var day=lesson.day-1
        var newList= listOf<Lesson>()
        var t=true
        for (i in lesson.classRoom){
            t=true
            for (i in Schedule[day][i-1].value){
                if (i.timeStart>=lesson.timeStart && t){
                    t=false
                    newList+=lesson
                }
                newList+=i
            }
            if (t){
                newList+=lesson
            }
            Schedule[day][i-1].value=newList
        }
    }
    fun del(lesson: Lesson){
        allLesson.removeAll{ it == lesson }
        for (i in Schedule){
            for (j in i){
                j.value=j.value.filterNot { it == lesson }
            }
        }
    }
    fun addLessonType(){

    }
    fun delLessonType(){

    }
    fun addTeacher(teacher: String){

    }
    fun delTeacher(teacher: Teacher){

    }
}