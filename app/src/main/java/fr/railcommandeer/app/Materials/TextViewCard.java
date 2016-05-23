package fr.railcommandeer.app.Materials;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.prototypes.CardWithList;
import it.gmariotti.cardslib.library.prototypes.LinearListView;


/**
 * Created by Boufle on 19/05/2016.
 */
public class TextViewCard extends TextView implements CardWithList.ListObject {

    public TextViewCard(Context context) {

        super(context);
        setOnItemClickListener(new CardWithList.OnItemClickListener() {
            @Override
            public void onItemClick(LinearListView parent, View view, int position, CardWithList.ListObject object) {
                Toast.makeText(getContext(), "Click on " + getObjectId(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public String getObjectId() {
        return null;
    }

    @Override
    public Card getParentCard() {
        return null;
    }

    @Override
    public void setOnItemClickListener(CardWithList.OnItemClickListener onItemClickListener) {

    }

    @Override
    public CardWithList.OnItemClickListener getOnItemClickListener() {
        return null;
    }

    @Override
    public boolean isSwipeable() {
        return false;
    }

    @Override
    public void setSwipeable(boolean b) {

    }

    @Override
    public CardWithList.OnItemSwipeListener getOnItemSwipeListener() {
        return null;
    }

    @Override
    public void setOnItemSwipeListener(CardWithList.OnItemSwipeListener onItemSwipeListener) {

    }
}
