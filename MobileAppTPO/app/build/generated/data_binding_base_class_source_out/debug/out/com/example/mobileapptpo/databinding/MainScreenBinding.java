// Generated by view binder compiler. Do not edit!
package com.example.mobileapptpo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.mobileapptpo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MainScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button izbiraNaprave;

  @NonNull
  public final Button izbiraStreznika;

  @NonNull
  public final Button seznanjeneNaprave;

  @NonNull
  public final Button seznanjeniStrezniki;

  @NonNull
  public final TextView textView;

  private MainScreenBinding(@NonNull ConstraintLayout rootView, @NonNull Button izbiraNaprave,
      @NonNull Button izbiraStreznika, @NonNull Button seznanjeneNaprave,
      @NonNull Button seznanjeniStrezniki, @NonNull TextView textView) {
    this.rootView = rootView;
    this.izbiraNaprave = izbiraNaprave;
    this.izbiraStreznika = izbiraStreznika;
    this.seznanjeneNaprave = seznanjeneNaprave;
    this.seznanjeniStrezniki = seznanjeniStrezniki;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MainScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MainScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.main_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MainScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.izbira_naprave;
      Button izbiraNaprave = ViewBindings.findChildViewById(rootView, id);
      if (izbiraNaprave == null) {
        break missingId;
      }

      id = R.id.izbira_streznika;
      Button izbiraStreznika = ViewBindings.findChildViewById(rootView, id);
      if (izbiraStreznika == null) {
        break missingId;
      }

      id = R.id.seznanjene_naprave;
      Button seznanjeneNaprave = ViewBindings.findChildViewById(rootView, id);
      if (seznanjeneNaprave == null) {
        break missingId;
      }

      id = R.id.seznanjeni_strezniki;
      Button seznanjeniStrezniki = ViewBindings.findChildViewById(rootView, id);
      if (seznanjeniStrezniki == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new MainScreenBinding((ConstraintLayout) rootView, izbiraNaprave, izbiraStreznika,
          seznanjeneNaprave, seznanjeniStrezniki, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
