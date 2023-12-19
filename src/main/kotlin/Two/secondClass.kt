package Two

import Lesson
import NNSBD
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import twoPanelRe

class SecondBlock(NNBD: NNSBD){
    var BD=NNBD
    var name = mutableStateOf("")
    var teacher= mutableStateOf("")

    var day = mutableStateOf("")
    var startOne = mutableStateOf("")
    var endOne = mutableStateOf("")
    var startTwo = mutableStateOf("")
    var endTwo = mutableStateOf("")

    var lessons = mutableListOf(mutableStateOf(""),mutableStateOf(""), mutableStateOf(""), mutableStateOf(""),mutableStateOf(""))

    var expandedTwo = mutableStateOf(false)
    var expandedOne = mutableStateOf(false)

    fun importFromLesson(lesson: Lesson){
        name = mutableStateOf(lesson.name)
        teacher= mutableStateOf(lesson.teacher)

        day = mutableStateOf(lesson.day.toString())
        startOne = mutableStateOf((lesson.timeStart/60).toString())
        endOne = mutableStateOf((lesson.timeEnd/60).toString())
        startTwo = mutableStateOf((lesson.timeStart%60).toString())
        endTwo = mutableStateOf((lesson.timeEnd%60).toString())

        lessons = mutableListOf<MutableState<String>>()
        for (i in lesson.classRoom){
            lessons.add(mutableStateOf( i.toString()))
        }
        while (lessons.size < 4) {
            lessons.add(mutableStateOf( "" ))
        }
    }

    fun add(){
        var les= mutableListOf<Int>()
        for (i in lessons){ if (i.value.toIntOrNull()!=null && i.value.toInt()<=BD.classroomInt){ les.add(i.value.toInt()) } }
        if (name.value!="" &&
            teacher.value!="" &&

            day.value.toIntOrNull()!=null &&
            day.value.toInt()<=BD.maxDay &&
            day.value.toInt()>0 &&

            startOne.value.toIntOrNull()!=null &&
            startOne.value.toInt()>=8 &&
            startOne.value.toInt()>0 &&
            endOne.value.toIntOrNull()!=null &&
            endOne.value.toInt()<=23 &&
            endOne.value.toInt()>0 &&

            startTwo.value.toIntOrNull()!=null &&
            startTwo.value.toInt()<=59 &&
            startTwo.value.toInt()>0 &&
            endTwo.value.toIntOrNull()!=null &&
            endTwo.value.toInt()<=59 &&
            endTwo.value.toInt()>0 &&

            les.size!=0

        ){
            var start = startOne.value.toInt()*60+startTwo.value.toInt()
            var end = endOne.value.toInt()*60+endTwo.value.toInt()
            BD.add(Lesson(name.value, day.value.toInt(), les, teacher.value, start, end))

            name.value=""
            teacher.value=""

            day.value=""
            startOne.value=""
            endOne.value=""
            startTwo.value=""
            endTwo.value=""
            lessons = mutableListOf(mutableStateOf(""), mutableStateOf(""), mutableStateOf(""), mutableStateOf(""), mutableStateOf(""))
        }
    }

    fun edit(lesson: Lesson){
        var les= mutableListOf<Int>()
        for (i in lessons){ if (i.value.toIntOrNull()!=null && i.value.toInt()<=BD.classroomInt){ les.add(i.value.toInt()) } }
        if (name.value!="" &&
            teacher.value!="" &&

            day.value.toIntOrNull()!=null &&
            day.value.toInt()<=BD.maxDay &&
            day.value.toInt()>0 &&

            startOne.value.toIntOrNull()!=null &&
            startOne.value.toInt()>=8 &&
            startOne.value.toInt()>0 &&
            endOne.value.toIntOrNull()!=null &&
            endOne.value.toInt()<=23 &&
            endOne.value.toInt()>0 &&

            startTwo.value.toIntOrNull()!=null &&
            startTwo.value.toInt()<=59 &&
            startTwo.value.toInt()>0 &&
            endTwo.value.toIntOrNull()!=null &&
            endTwo.value.toInt()<=59 &&
            endTwo.value.toInt()>0 &&

            les.size!=0

        ){
            var start = startOne.value.toInt()*60+startTwo.value.toInt()
            var end = endOne.value.toInt()*60+endTwo.value.toInt()
            BD.del(lesson)
            BD.add(Lesson(name.value, day.value.toInt(), les, teacher.value, start, end))
            twoPanelRe.value=false
        }
    }

    fun del(lesson: Lesson){
        BD.del(lesson)
        twoPanelRe.value=false
    }
}