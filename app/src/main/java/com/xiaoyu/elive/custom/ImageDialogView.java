package com.xiaoyu.elive.custom;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;

import com.xiaoyu.elive.R;

public class ImageDialogView extends Dialog {

    public ImageDialogView(Context context) {
        super(context);
    }

    public ImageDialogView(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {
        private Context context;
        private Bitmap image;

        public Builder(Context context) {
            this.context = context;
        }

        public Bitmap getImage() {
            return image;
        }

        public void setImage(Bitmap image) {
            this.image = image;
        }

        public ImageDialogView create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final ImageDialogView dialog = new ImageDialogView(context, R.style.Dialog);
            View layout = inflater.inflate(R.layout.custom_img_dialog, null);
            dialog.addContentView(layout, new LayoutParams(
                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT
                    , android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
            dialog.setContentView(layout);
            ImageView img = (ImageView) layout.findViewById(R.id.dialog_img);

            img.setImageBitmap(getImage());
            return dialog;
        }
    }
}
