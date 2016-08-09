package com.example.moham.tictactoe;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    Point userMove = new Point(6, 6);
    boolean Flag = false;
    Button button00, button01, button02, button10, button11, button12, button20, button21, button22;
    static int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        button00 = (Button) findViewById(R.id.btn_0_0);
        button01 = (Button) findViewById(R.id.btn_0_1);
        button02 = (Button) findViewById(R.id.btn_0_2);
        button10 = (Button) findViewById(R.id.btn_1_0);
        button11 = (Button) findViewById(R.id.btn_1_1);
        button12 = (Button) findViewById(R.id.btn_1_2);
        button20 = (Button) findViewById(R.id.btn_2_0);
        button21 = (Button) findViewById(R.id.btn_2_1);
        button22 = (Button) findViewById(R.id.btn_2_2);


        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMove = new Point(0, 0);
                Flag = true;

            }
        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMove = new Point(0, 1);
                Flag = true;

            }
        });

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMove = new Point(0, 2);
                Flag = true;

            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMove = new Point(1, 0);
                Flag = true;

            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMove = new Point(1, 1);
                Flag = true;

            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMove = new Point(1, 2);
                Flag = true;

            }
        });

        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMove = new Point(2, 0);
                Flag = true;

            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMove = new Point(2, 1);
                Flag = true;

            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMove = new Point(2, 2);
                Flag = true;

            }
        });

        System.out.println("ddddddddddddddddddddddddddddddd" + getIntent().getIntExtra("player", 5));

        Thread thread = new Thread() {

            public void run() {
                Board b = new Board();
                Random rand = new Random();
                int choice =2;
                System.out.println("ddddddddddddddddddd" + choice);
                if (choice == 1) {
                    Point p = new Point(rand.nextInt(2), rand.nextInt(2));
                    b.placeAMove(p, 1);

                    System.out.println("dddddddddddddd" + p);
                   // turn = 1;
                    PlaceMove(p,1);
                }


                while (!b.isGameOver()) {
                    if (Flag) {
                        b.placeAMove(userMove, 2);
                       // turn = 2;
                        PlaceMove(userMove,2);
                        if (b.isGameOver()) {
                            break;
                        }

                        b.minimax(0, 1);
                        b.placeAMove(b.computersMove, 1);
                     //   turn = 1;
                        PlaceMove(b.computersMove,1);
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Flag = false;
                    }
                }

                if (b.hasXWon()) {
//                    Toast.makeText(getApplicationContext(), "Unfortunately, you lost!", Toast.LENGTH_SHORT).show();
                    System.out.println("dddddddddddddddddddLost");
                } else if (b.hasOWon()) {
//                    Toast.makeText(getApplication(), " you Won!", Toast.LENGTH_SHORT).show();
                    System.out.println("dddddddddddddddddddWon");

                } else {
//                    Toast.makeText(getApplication(), "It's a draw!!", Toast.LENGTH_SHORT).show();
                    System.out.println("ddddddddddddddddddddraw");

                }
            }
        };
        thread.start();
//        runOnUiThread(thread);
    }

    public void PlaceMove(final Point p,final int turn) {
        if (p.x == 0 && p.y == 0) {
            button00.post(new Runnable() {
                @Override
                public void run() {
                    button00.setText(turn + "");
                    button00.setEnabled(false);
                    System.err.println("dddddddddddddddddddd" + p);
                }
            });
        } else if (p.x == 0 && p.y == 1) {
            button01.post(new Runnable() {
                @Override
                public void run() {
                    button01.setText(turn + "");
                    button01.setEnabled(false);
                    System.err.println("dddddddddddddddddddd" + p);
                }
            });
        } else if (p.x == 0 && p.y == 2) {
            button02.post(new Runnable() {
                @Override
                public void run() {
                    button02.setText(turn + "");
                    button02.setEnabled(false);
                    System.err.println("dddddddddddddddddddd" + p);

                }
            });
        } else if (p.x == 1 && p.y == 0) {
            button10.post(new Runnable() {
                @Override
                public void run() {
                    button10.setText(turn + "");
                    button10.setEnabled(false);
                    System.err.println("dddddddddddddddddddd" + p);

                }
            });
        } else if (p.x == 1 && p.y == 1) {
            button11.post(new Runnable() {
                @Override
                public void run() {
                    button11.setText(turn + "");
                    button11.setEnabled(false);
                    System.err.println("dddddddddddddddddddd" + p);

                }
            });
        } else if (p.x == 1 && p.y == 2) {
            button12.post(new Runnable() {
                @Override
                public void run() {
                    button12.setText(turn + "");
                    button12.setEnabled(false);
                    System.err.println("dddddddddddddddddddd" + p);

                }
            });
        } else if (p.x == 2 && p.y == 0) {
            button20.post(new Runnable() {
                @Override
                public void run() {
                    button20.setText(turn + "");
                    button20.setEnabled(false);
                    System.err.println("dddddddddddddddddddd" + p);

                }
            });
        } else if (p.x == 2 && p.y == 1) {
            button21.post(new Runnable() {
                @Override
                public void run() {
                    button21.setText(turn + "");
                    button21.setEnabled(false);
                    System.err.println("dddddddddddddddddddd" + p);

                }
            });
        } else if (p.x == 2 && p.y == 2) {
            button22.post(new Runnable() {
                @Override
                public void run() {
                    button22.setText(turn + "");
                    button22.setEnabled(false);
                    System.err.println("dddddddddddddddddddd" + p);

                }
            });
        }


    }

}
