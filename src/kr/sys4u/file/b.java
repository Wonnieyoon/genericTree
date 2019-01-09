namespace InvertedButtonModel
{
    abstract class ButtonClient
    {
        public abstract void TurnOn();
        public abstract void TurnOff();
    }


    class Lamp : ButtonClient
    {
        public override void TurnOn()
        {
            Console.WriteLine("Lamp 램프를 켭니다.");
        }

        public override void TurnOff()
        {
            Console.WriteLine("Lamp 램프를 끕니다.");
        }
    }


    abstract class Button
    {
        private ButtonClient buttonClient;

        public Button(ButtonClient client)
        {
            this.buttonClient = client;
        }
        public void Detect()
        {
            bool buttonOn = GetState();
            if (buttonOn)
            {
                buttonClient.TurnOn();
            }
            else
            {
                buttonClient.TurnOff();
            }
        }
        public abstract bool GetState();


    }

    class ButtonImplementation : Button
    {
        public ButtonImplementation(ButtonClient client):base(client){}

        public override bool GetState(){
            bool isPressed = false;
            //물리적 장치를 감지하여 반환
            return isPressed;
        }

    }
}
