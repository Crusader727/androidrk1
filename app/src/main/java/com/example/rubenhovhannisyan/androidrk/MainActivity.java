package com.example.rubenhovhannisyan.androidrk;


import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        final ArticleListFragment articleList = new ArticleListFragment();
        articleList.setOnArticleClickListener(new OnArticleListener());

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            transaction.replace(R.id.container_l, articleList);
        } else {
            transaction.replace(R.id.container, articleList);
        }

        transaction.commit();

    }


    private class OnArticleListener implements OnArticleClickListener {
        @Override
        public void onArticleClick(Article article) {

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            ArticleFragment articleFragment = new ArticleFragment();

            final Bundle bundle = new Bundle();
            bundle.putString("title", article.getTitle());
            bundle.putString("date", article.getDate().toString());
            bundle.putString("content", article.getContent());

            articleFragment.setArguments(bundle);

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                transaction.replace(R.id.container, articleFragment);
                transaction.addToBackStack(null);
            } else {
                transaction.replace(R.id.container_r, articleFragment);
            }
            transaction.commit();
        }
    }
}
