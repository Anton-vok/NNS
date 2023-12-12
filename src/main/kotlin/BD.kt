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

class LessonType(nTeacherList: MutableList<Teacher>, nName : String) : ToSelectPanel {
    override var name = nName
    var teacherList = nTeacherList
}

class NNSBD(day: Int, classroom: Int){

    var classroomInt=classroom

    var allLesson = mutableListOf<Lesson>()
    var Schedule = Array<Array<MutableState<List<Lesson>>>> (day) { Array<MutableState<List<Lesson>>> (classroom) {mutableStateOf( listOf<Lesson>() ) } }
    var lessonType = mutableStateOf( listOf<LessonType>() )
    var teachers = mutableStateOf( listOf<Teacher>() )
    var errors = mutableStateOf(listOf<Pair<Lesson, Lesson>>())

    fun add(lesson: Lesson){
        findError(lesson)
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
        for (i in errors.value){
            if (lesson == i.second || lesson == i.second){
                errors.value=errors.value.filterNot { it == i }
            }
        }
    }
    fun addLessonType(lesson: LessonType){
        lessonType.value+=lesson
    }
    fun delLessonType(lesson: LessonType){
        lessonType.value=lessonType.value.filterNot { it == lesson }
    }
    fun addTeacher(teacher: String){
        teachers.value+=Teacher(teacher)
    }
    fun delTeacher(teacher: Teacher){
        teachers.value=teachers.value.filterNot { it == teacher }
    }
    fun findLesTea(lesson: String, classroom: Int, teacher: MutableState<String>){
        for (i in lessonType.value){
            if (i.name==lesson){
                teacher.value=i.teacherList[classroom].name
            }
        }
    }

    fun findError(lesson: Lesson){
        var day=lesson.day
        for (i in Schedule[day-1]){
            for (j in allLesson){
                if ((j.timeStart<= lesson.timeStart && lesson.timeStart<= j.timeEnd) || (j.timeStart>= lesson.timeStart && lesson.timeStart>= j.timeEnd) && (lesson.day==j.day) && (lesson.teacher==j.teacher)){
                    errors.value=errors.value+ Pair(lesson, j)
                }
            }
        }
    }
}