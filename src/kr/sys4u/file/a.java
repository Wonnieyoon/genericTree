namespace TradButtonModel
{
    class Lamp{
        public void TurnOn()
        {
            Console.WriteLine("Trad Lamp 램프를 켭니다.");
        }
        public void TurnOff()
        {
            Console.WriteLine("Trad Lamp 램프를 끕니다.");
        }
    }

    class Button {
        private Lamp itsLamp;

        public Button(Lamp lamp)
        {
            this.itsLamp = lamp;
        }

        public void Detect()
        {
            bool buttonOn = GetPhysicalState();
            if (buttonOn)
            {
                itsLamp.TurnOn();
            }
            else
            {
                itsLamp.TurnOff();
            }
        }

        private bool GetPhysicalState()
        {
            bool isPressed = false;
            //물리적 장치가 눌려저 있으면 true 를 반환
            return isPressed;
        }
    }



}
