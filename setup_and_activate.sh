if [ ! -d "venv" ]; then
    python3 -m venv venv
fi


source venv/bin/activate


pip install --upgrade pip
pip install pytz


python create_contest_folder.py
