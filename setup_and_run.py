import os
import subprocess
import sys

VENV_DIR = "venv"
REQUIRED_PACKAGES = ["pytz"]
FOLDER_SCRIPT = "create_contest_folder.py" 

def create_venv():
    if not os.path.isdir(VENV_DIR):
        print(f"Creating virtual environment in ./{VENV_DIR} ...")
        subprocess.check_call([sys.executable, "-m", "venv", VENV_DIR])
    else:
        print("Virtual environment already exists.")

def install_packages():
    pip_path = os.path.join(VENV_DIR, "bin", "pip") if os.name != "nt" else os.path.join(VENV_DIR, "Scripts", "pip.exe")
    for pkg in REQUIRED_PACKAGES:
        subprocess.check_call([pip_path, "install", pkg], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)

def main():
    create_venv()
    install_packages()
    print(f"\nTo activate your environment, run:\n    source {VENV_DIR}/bin/activate\n")
    print(f"Running {FOLDER_SCRIPT} ...\n")
    python_path = os.path.join(VENV_DIR, "bin", "python") if os.name != "nt" else os.path.join(VENV_DIR, "Scripts", "python.exe")
    subprocess.call([python_path, FOLDER_SCRIPT])

if __name__ == "__main__":
    main()
