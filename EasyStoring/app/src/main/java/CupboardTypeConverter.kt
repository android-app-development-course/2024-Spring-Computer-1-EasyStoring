import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.easystoring.Cupboard
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
class CupboardTypeConverter {
    val gson = Gson()

//    @TypeConverter
//    fun fromCupboard(cupboards: MutableList<Cupboard>): String {
//        val jsonString = gson.toJson(cupboards)
//        return jsonString
//    }
//
//    @TypeConverter
//    fun toCupboard(jsonString: String): MutableList<Cupboard> {
//        val type = object : TypeToken<MutableList<Cupboard>>() {}.type
//        val list: MutableList<Cupboard> = gson.fromJson(jsonString, type)
//        return list
//    }
    @TypeConverter
    fun fromMap(map: Map<Int,Int> ):String{
        val jsonString=gson.toJson(map)
    return jsonString
    }

    @TypeConverter
    fun toMap(jsonString:String):Map<Int,Int>
    {
        val type=object :TypeToken<Map<Int,Int>>(){}.type
        val map:Map<Int,Int> = gson.fromJson(jsonString,type)
        return map
    }
}