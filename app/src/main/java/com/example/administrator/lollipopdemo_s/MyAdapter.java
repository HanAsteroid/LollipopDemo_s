package com.example.administrator.lollipopdemo_s;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 15-7-20.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
//    private List<String> list;
    private List<Integer>list;
    private MyOnChildClickListener listener;
    private RecyclerView recycler;
    public MyAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recycler = recyclerView;
    }
    public void setMyOnChildClicker(MyOnChildClickListener listener){
        this.listener = listener;
    }

    /**
     * 创建ViewHolder
     * @param viewGroup
     * @param i 如果有多个布局,可以通过i来区分
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        view.setOnClickListener(this);
        return  new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
//        viewHolder.text.setText(list.get(i));
        //此处代码获取屏幕的宽高，实现不同屏幕的适配
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Bitmap bitmap = readBitMap(context, list.get(i));
//        Bitmap bitmap = Bitmap.createBitmap(bitmap1.getWidth(), bitmap1.getHeight(), Bitmap.Config.ARGB_8888);
//        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),list.get(i));
        int width = wm.getDefaultDisplay().getWidth()/3;
        int height = width * bitmap.getHeight() / bitmap.getWidth();//高通过宽等比例缩放
        Log.v("TAG","----->height=="+height);
        //获取item的LayoutParams参数

//        ViewGroup.LayoutParams params = viewHolder.itemView.getLayoutParams();
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(width,height);
//        params.height = height;
        viewHolder.itemView.setLayoutParams(params1);
        viewHolder.img.setImageBitmap(bitmap);


//        viewHolder.img.setImageResource(list.get(i));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void reMove(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            int position = recycler.getChildAdapterPosition(v);
            listener.myOnChildVlick(v,position,list.get(position));
        }

    }
//  最省内存的获取本地图片资源
    public static Bitmap readBitMap(Context context, int resId){

        BitmapFactory.Options opt = new BitmapFactory.Options();

        opt.inPreferredConfig = Bitmap.Config.RGB_565;

        opt.inPurgeable = true;

        opt.inInputShareable = true;

        //获取资源图片

        InputStream is = context.getResources().openRawResource(resId);

        return BitmapFactory.decodeStream(is,null,opt);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private TextView text;
        private ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
//            text = ((TextView) itemView.findViewById(R.id.text));
            img = ((ImageView) itemView.findViewById(R.id.image));
        }

    }

    public interface MyOnChildClickListener{
        void myOnChildVlick(View v,int position,Integer data);
    }
}
