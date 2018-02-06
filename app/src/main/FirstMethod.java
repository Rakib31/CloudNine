 public void first()
    {
        setContentView(R.layout.welcome);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                text = (TextView)findViewById(R.id.textView);
                for(int i=0; i<100; i++)
                {
                    try
                    {
                        Thread.sleep(10);
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    text.setTextSize(i);
                }
                setContentView(R.layout.activity_main);
            }
        });
    }