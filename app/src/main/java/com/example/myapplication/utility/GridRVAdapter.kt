import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.data_model.GridViewModel

internal class MainAdapter(
     private val context: Context,
    private val numbersInWords: Array<String>,
    private val numberImage: IntArray
) :
    BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    override fun getCount(): Int {
         return numbersInWords.size
        }
    override fun getItem(position: Int): Any? {
         return null
        }
    override fun getItemId(position: Int): Long {
         return 0
        }
    override fun getView(
        position: Int,
    convertView: View?,
    parent: ViewGroup
    ): View? {
         var convertView = convertView
         if (layoutInflater == null) {
          layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
             }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.card_item, null)
             }
        imageView = convertView!!.findViewById(R.id.gridImage)
         textView = convertView.findViewById(R.id.cardTitle)
       imageView.setImageResource(numberImage[position])
        textView.text = numbersInWords[position]
       return convertView
    }
}






















//
//internal class GridRVAdapter(private val gridList:ArrayList<GridViewModel>, private val context:Context): BaseAdapter() {
//    private var layoutInflater:LayoutInflater? = null
//    private lateinit var imageViewCard:ImageView
//    private lateinit var textViewCard: TextView
//    override fun getCount(): Int {
//        return gridList.size
//    }
//
//    override fun getItem(position: Int): Any? {
//        return null
//    }
//
//    override fun getItemId(position: Int): Long {
//        return 0
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        var convert = convertView;
//       if(layoutInflater == null){
//           layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//       }
//        if(convertView == null ){
//            convert = layoutInflater!!.inflate(R.layout.card_item, null)
//        }
//        imageViewCard = convert!!.findViewById(R.id.gridImage)
//        textViewCard = convert!!.findViewById(R.id.cardTitle)
//        imageViewCard.setImageResource(gridList[position].image)
//        textViewCard.setText(gridList[position].label)
//        return convert
//    }
//
//
//}