package com.example.barcode.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CameraActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
//    private static final int REQUEST_TAKE_PHOTO = 1;
//    private Uri photoURI;
//    private String mCurrentPhotoPath;
//    private ImageView imageView;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        Button photoButton = (Button) findViewById(R.id.buttonLoadPicture);
//        imageView = (ImageView) findViewById(R.id.imgGall);

//    }

//    public void onPhotoClick(View view) {
//        Log.println(Log.INFO, "test", "test");
//        dispatchTakePictureIntent();
//    }
//
//    private File createImageFile() throws IOException {
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        String imageFileName = "JPEG_" + timeStamp + "_";
//        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(
//                imageFileName,
//                ".jpg",
//                storageDir
//        );
//
//        mCurrentPhotoPath = image.getAbsolutePath();
//        return image;
//    }
//
//    private void dispatchTakePictureIntent() {
//
////        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            File photoFile = null;
//            try {
//                photoFile = createImageFile();
//            } catch (IOException ex) {
//                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
//            }
//            if (photoFile != null) {
//
//            }
////        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
//            Uri uri = Uri.parse(mCurrentPhotoPath);
//            imageView.setImageURI(uri);
//        }
//    }
}