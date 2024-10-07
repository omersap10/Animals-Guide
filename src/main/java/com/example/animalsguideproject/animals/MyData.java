package com.example.animalsguideproject.animals;

import android.content.Context;

import com.example.animalsguideproject.R;

public class MyData
{

    public static String[] getAnimalNames(Context context) {
        return new String[] {
                context.getString(R.string.animal_name_lion),
                context.getString(R.string.animal_name_elephant),
                context.getString(R.string.animal_name_giraffe),
                context.getString(R.string.animal_name_panda),
                context.getString(R.string.animal_name_tiger),
                context.getString(R.string.animal_name_bear),
                context.getString(R.string.animal_name_rhino),
                context.getString(R.string.animal_name_hippo),
                context.getString(R.string.animal_name_wolf),
                context.getString(R.string.animal_name_monkey)
        };
    }

    public static String[] getAnimalDescriptions(Context context) {
        return new String[] {
                context.getString(R.string.animal_desc_lion),
                context.getString(R.string.animal_desc_elephant),
                context.getString(R.string.animal_desc_giraffe),
                context.getString(R.string.animal_desc_panda),
                context.getString(R.string.animal_desc_tiger),
                context.getString(R.string.animal_desc_bear),
                context.getString(R.string.animal_desc_rhino),
                context.getString(R.string.animal_desc_hippo),
                context.getString(R.string.animal_desc_wolf),
                context.getString(R.string.animal_desc_monkey)
        };
    }

    public static Integer[] drawableArray = {
            R.drawable.lion, R.drawable.elephant, R.drawable.giraffe, R.drawable.panda,
            R.drawable.tiger, R.drawable.bear, R.drawable.rhino, R.drawable.hippo,
            R.drawable.wolf, R.drawable.monkey};

    public static Integer[] id = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
}
