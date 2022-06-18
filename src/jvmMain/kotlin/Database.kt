import java.io.*

class Database {

    var contentList = ArrayList<MediaObject>()
    var data = File("D:\\JavaProjects\\contentTracker\\src\\jvmMain\\resources\\data")

    init {
        loadDB()
    }

    // converts the line to a list of values the contentList can accept
    private fun convertLine(line: String): MediaObject {

        var template = ArrayList<String>()

        var spl = line.split("[s]")

        for (value in spl) {
            template.add(value)
        }
        return MediaObject(template[0], template[1].toInt(), template[2].toDouble(), template[3])
    }

    //generates contentList from the file
     fun loadDB(){
        var reader = BufferedReader(FileReader(data))
        if (reader.lines() != null) {

            for (line in reader.lines()) {
                contentList.add(convertLine(line))
            }
        }
        reader.close()
    }

    //updates file with contents of contentList from session
     fun pushList(){



    }





}