package com.example.amharickeyboard;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class AmharicKeyboard extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView keyboardView;
    private Keyboard keyboard;
    private int key_family = 0;
    int first_time_selected = 0;
    LinearLayout mCandidateView;
    LinearLayout innerLayout;
    TextView suggestion1;
    TextView suggestion2;
    TextView suggestion3;
    TextView suggestion4;
    InputConnection inputConnection;




    @Override
    public View onCreateInputView() {

        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard,null);
        keyboard = new Keyboard(this, R.xml.amharic);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public View onCreateCandidatesView() {
        mCandidateView = (LinearLayout) getLayoutInflater().inflate(R.layout.prediction,null);
        innerLayout = mCandidateView.findViewById(R.id.innerLayout);

        suggestion1 = innerLayout.findViewById(R.id.suggestion1);
        suggestion2 = innerLayout.findViewById(R.id.suggestion2);
        suggestion3 = innerLayout.findViewById(R.id.suggestion3);
        suggestion4 = innerLayout.findViewById(R.id.suggestion4);

        setCandidatesViewShown(true);
        return mCandidateView;
    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int i, int[] ints) {

        inputConnection = getCurrentInputConnection();
        switchKeyboard(inputConnection,i);

        switch (i){
            case -1:
//                Log.d("TAG", "onKey: delete");
                inputConnection.deleteSurroundingText(1,0);
                createSuggestion("");

                break;
            default:
//                Log.d("TAG", "onKey: default ");
                char c = (char) i;
                inputConnection.commitText(String.valueOf(c),1);
                createSuggestion("");


        }

    }

    void createSuggestion(String inputString){
        String s = inputConnection.getExtractedText(new ExtractedTextRequest(),0).text.toString();
        suggestion1.setText(s);
    }

    public void selectSuggestion(View view){
        TextView tv = (TextView) view;
        String s = tv.getText().toString();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(s.split(" ")));
        int x = arrayList.get(arrayList.size()-1).length();
        inputConnection.deleteSurroundingText(x,1);
        inputConnection.commitText("ትቆማ",1);
    }

    public void switchKeyboard(InputConnection inputConnection,int code){
        String s = Integer.toString(code);

        if(code != -1){
            if((key_family != 0) && (key_family != code) && (code >= key_family - 5) && (code <= key_family +2)){

                if(first_time_selected ==0){
                    inputConnection.deleteSurroundingText(1,0);
                }
                first_time_selected++;
                return;
            }
            if((code==32 || code==4965 || code==4964 || code==4962)){
                return;
            }

        }
        switch (code){
            case 4608:
            case 4609:
            case 4610:
            case 4611:
            case 4612:
            case 4613:
            case 4614:
            case 4615:
                key_family = 4613;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.h_amharic);
                break;
            case 4616:
            case 4617:
            case 4618:
            case 4619:
            case 4620:
            case 4621:
            case 4622:
            case 4623:

                key_family = 4621;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.l_amharic);
                break;
            case 4624:
            case 4625:
            case 4626:
            case 4627:
            case 4628:
            case 4629:
            case 4630:
            case 4631:
                key_family = 4629;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.hh_amharic);
                break;
            case 4632:
            case 4633:
            case 4634:
            case 4635:
            case 4636:
            case 4637:
            case 4638:
            case 4639:
                key_family = 4637;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.m_amharic);
                break;
            case 4640:
            case 4641:
            case 4642:
            case 4643:
            case 4644:
            case 4645:
            case 4646:
            case 4647:
                key_family = 4645;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.s_amharic);
                break;
            case 4648:
            case 4649:
            case 4650:
            case 4651:
            case 4652:
            case 4653:
            case 4654:
            case 4655:
                key_family = 4653;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.r_amharic);
                break;
            case 4656:
            case 4657:
            case 4658:
            case 4659:
            case 4660:
            case 4661:
            case 4662:
            case 4663:
                key_family = 4661;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.ss_amharic);
                break;
            case 4664:
            case 4665:
            case 4666:
            case 4667:
            case 4668:
            case 4669:
            case 4670:
            case 4671:
                key_family = 4669;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.sh_amharic);
                break;
            case 4672:
            case 4673:
            case 4674:
            case 4675:
            case 4676:
            case 4677:
            case 4678:
            case 4679:
                key_family = 4677;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.q_amharic);
                break;
            case 4704:
            case 4705:
            case 4706:
            case 4707:
            case 4708:
            case 4709:
            case 4710:
            case 4711:

                key_family = 4709;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.b_amharic);
                break;
            case 4720:
            case 4721:
            case 4722:
            case 4723:
            case 4724:
            case 4725:
            case 4726:
            case 4727:
                key_family = 4725;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.t_amharic);
                break;
            case 4728:
            case 4729:
            case 4730:
            case 4731:
            case 4732:
            case 4733:
            case 4734:
            case 4735:
                key_family = 4733;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.ch_amharic);
                break;
            case 4736:
            case 4737:
            case 4738:
            case 4739:
            case 4740:
            case 4741:
            case 4742:
            case 4743:
                key_family = 4741;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.hhh_amharic);
                break;
            case 4752:
            case 4753:
            case 4754:
            case 4755:
            case 4756:
            case 4757:
            case 4758:
            case 4759:
                key_family = 4757;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.n_amharic);
                break;
            case 4760:
            case 4761:
            case 4762:
            case 4763:
            case 4764:
            case 4765:
            case 4766:
            case 4767:
                key_family = 4765;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.ng_amharic);
                break;
            case 4768:
            case 4769:
            case 4770:
            case 4771:
            case 4772:
            case 4773:
            case 4774:
            case 4775:
                key_family = 4773;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.a_amharic);
                break;
            case 4776:
            case 4777:
            case 4778:
            case 4779:
            case 4780:
            case 4781:
            case 4782:
            case 4783:
                key_family = 4781;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.k_amharic);
                break;
            case 4792:
            case 4793:
            case 4794:
            case 4795:
            case 4796:
            case 4797:
            case 4798:
            case 4799:
                key_family = 4797;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.q_amharic);
                break;
            case 4712:
            case 4713:
            case 4714:
            case 4715:
            case 4716:
            case 4717:
            case 4718:
            case 4719:

                key_family = 4717;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.v_amharic);
                break;
            case 4804:
            case 4805:
            case 4806:
            case 4807:
            case 4808:
            case 4809:
            case 4810:
            case 4811:
                key_family = 4809;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.w_amharic);
                break;
            case 4816:
            case 4817:
            case 4818:
            case 4819:
            case 4820:
            case 4821:
            case 4822:
            case 4823:
                key_family = 4821;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.aaa_amharic);
                break;
            case 4824:
            case 4825:
            case 4826:
            case 4827:
            case 4828:
            case 4829:
            case 4830:
            case 4831:
                key_family = 4829;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.z_amharic);
                break;
            case 4832:
            case 4833:
            case 4834:
            case 4835:
            case 4836:
            case 4837:
            case 4838:
            case 4839:
                key_family = 4837;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.zh_amharic);
                break;
            case 4840:
            case 4841:
            case 4842:
            case 4843:
            case 4844:
            case 4845:
            case 4846:
            case 4847:
                key_family = 4845;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.y_amharic);
                break;
            case 4848:
            case 4849:
            case 4850:
            case 4851:
            case 4852:
            case 4853:
            case 4854:
            case 4855:
                key_family = 4853;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.d_amharic);
                break;
            case 4864:
            case 4865:
            case 4866:
            case 4867:
            case 4868:
            case 4869:
            case 4870:
            case 4871:
                key_family = 4869;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.j_amharic);
                break;
            case 4872:
            case 4873:
            case 4874:
            case 4875:
            case 4876:
            case 4877:
            case 4878:
            case 4879:
                key_family = 4877;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.g_amharic);
                break;
            case 4896:
            case 4897:
            case 4898:
            case 4899:
            case 4900:
            case 4901:
            case 4902:
            case 4903:
                key_family = 4901;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.xe_amharic);
                break;
            case 4904:
            case 4905:
            case 4906:
            case 4907:
            case 4908:
            case 4909:
            case 4910:
            case 4911:
                key_family = 4909;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.c_amharic);
                break;
            case 4920:
            case 4921:
            case 4922:
            case 4923:
            case 4924:
            case 4925:
            case 4926:
            case 4927:
                key_family = 4925;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.ts_amharic);
                break;

            case 4928:
            case 4929:
            case 4930:
            case 4931:
            case 4932:
            case 4933:
            case 4934:
            case 4935:
                key_family = 4933;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.ts2_amharic);
                break;
            case 4936:
            case 4937:
            case 4938:
            case 4939:
            case 4940:
            case 4941:
            case 4942:
            case 4943:
                key_family = 4941;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.f_amharic);
                break;
            case 4944:
            case 4945:
            case 4946:
            case 4947:
            case 4948:
            case 4949:
            case 4950:
            case 4951:
                key_family = 4949;
                first_time_selected = 0;
                keyboard = new Keyboard(this,R.xml.p_amharic);
                break;

        }
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
