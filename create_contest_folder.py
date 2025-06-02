import os
from datetime import datetime
import pytz
import sys

def get_user_input(prompt_text):
    print(prompt_text, end="", file=sys.stderr, flush=True)
    return sys.stdin.readline().strip()

def ordinal(n):
    if 10 <= n % 100 <= 20:
        suffix = "th"
    else:
        suffix = {1: "st", 2: "nd", 3: "rd"}.get(n % 10, "th")
    return f"{n}{suffix}"

def print_header(text, file=sys.stderr):
    print("\n" + "=" * 40, file=file)
    print(text, file=file)
    print("=" * 40 + "\n", file=file)

def platform_fullname(shortcut, folder_type):
    shortcut = shortcut.lower()
    if shortcut in ["l", "leetcode"]:
        return "LC_Daily" if folder_type == "daily" else "LC_Contest"
    if shortcut in ["c", "codeforces"]:
        return "CF_Daily" if folder_type == "daily" else "CF_Contest"
    if shortcut in ["g", "gfg"]:
        return "GFG_Daily" if folder_type == "daily" else "GFG_Contest"
    return shortcut

def folder_type_fullname(shortcut):
    shortcut = shortcut.lower()
    if shortcut in ["d", "daily"]:
        return "daily"
    if shortcut in ["c", "contest"]:
        return "contest"
    return shortcut

def create_files_in_folder(folder, is_daily, num_questions=0):
    try:
        if is_daily:
            os.makedirs(folder, exist_ok=True)
            filenames = ["readme.md", "solution.md", "solution.java"]
            for fname in filenames:
                file_path = os.path.join(folder, fname)
                with open(file_path, "w") as f:
                    if fname == "readme.md":
                        f.write(f"# Daily Problem {os.path.basename(folder)}\n")
                    elif fname == "solution.md":
                        f.write(f"# Solution for {os.path.basename(folder)}\n")
                print(f"  Created file: {file_path}", file=sys.stderr)
        else:
            os.makedirs(folder, exist_ok=True)
            for i in range(1, num_questions + 1):
                q_folder = os.path.join(folder, f"q{i}")
                os.makedirs(q_folder, exist_ok=True)
                print(f"  Created: {q_folder}", file=sys.stderr)
                filenames = ["readme.md", "solution.md", "solution.java"]
                for fname in filenames:
                    file_path = os.path.join(q_folder, fname)
                    with open(file_path, "w") as f:
                        if fname == "readme.md":
                            f.write(f"# Problem q{i}\n")
                        elif fname == "solution.md":
                            f.write(f"# Solution for q{i}\n")
                    print(f"    Created file: {file_path}", file=sys.stderr)
        return True
    except Exception as e:
        print(f"Error creating files: {e}", file=sys.stderr)
        return False

def main():
    print_header("Competitive Programming Folder Creator")
    
    folder_type_input = get_user_input(
        "Type of folder? (daily/contest or d/c): "
    ).lower()
    folder_type = folder_type_fullname(folder_type_input)
    if folder_type not in ["daily", "contest"]:
        print(
            "Invalid folder type. Use 'daily' (or 'd') or 'contest' (or 'c').",
            file=sys.stderr
        )
        return

    platform_input = get_user_input(
        "Platform (l/c/g or leetcode/codeforces/gfg): "
    ).lower()
    platform = platform_fullname(platform_input, folder_type)

    created = False
    path_to_change_into = None
    user_confirmed_ok = False

    if folder_type == "daily":
        tz = pytz.timezone("Asia/Kolkata")
        now = datetime.now(tz)
        date = now.day
        month = now.strftime("%B")
        folder_name = f"{ordinal(date)}{month}{now.year % 100}"
        month_folder = os.path.join(platform, month)
        full_folder_path = os.path.join(month_folder, folder_name)
        print(f"\nToday is {ordinal(date)} {month} {now.year}.", file=sys.stderr)
        print(
            f"This is the folder that will be created: {full_folder_path}",
            file=sys.stderr
        )
        ok = get_user_input("Is this OK? (y/n): ").lower()
        user_confirmed_ok = (ok == "y")
        if not user_confirmed_ok:
            print("Aborted.", file=sys.stderr)
            return
        created = create_files_in_folder(full_folder_path, is_daily=True)
        if created:
            path_to_change_into = full_folder_path
    elif folder_type == "contest":
        num_questions_str = ""
        if platform == "LC_Contest":
            wb = get_user_input("Weekly or Biweekly? (w/b): ").lower()
            contest_type = "Weekly" if wb == "w" else "Biweekly"
            contest_number = get_user_input("Contest number: ")
            num_questions_str = get_user_input("How many questions?: ")
            folder_name = f"{contest_type}{contest_number}"
        elif platform == "CF_Contest":
            contest_number = get_user_input("Contest Number: ")
            div_number = get_user_input("Div Number : ")
            num_questions_str = get_user_input("How many questions?: ")
            folder_name = f"{contest_number}_Div{div_number}"
        else:
            folder_name = get_user_input(
                "Contest folder name (e.g., Starters206): "
            )
            num_questions_str = get_user_input(
                "Number of questions in contest: "
            )
        
        try:
            num_questions = int(num_questions_str)
            if num_questions <= 0:
                print("Number of questions must be positive.", file=sys.stderr)
                return
        except ValueError:
            print("Invalid number of questions.", file=sys.stderr)
            return

        base_folder = os.path.join(platform, folder_name)
        print(f"\nThis is the folder that will be created: {base_folder}", file=sys.stderr)
        ok = get_user_input("Is this OK? (y/n): ").lower()
        user_confirmed_ok = (ok == "y")
        if not user_confirmed_ok:
            print("Aborted.", file=sys.stderr)
            return
        created = create_files_in_folder(
            base_folder, is_daily=False, num_questions=num_questions
        )
        if created:
            path_to_change_into = base_folder
    else:
        print("Invalid folder type. Use 'daily' or 'contest'.", file=sys.stderr)
        return

    if created and path_to_change_into:
        print_header("Folders and files created successfully!")
        try:
            os.chdir(path_to_change_into) # Script changes its own CWD
            print(f"Script's CWD changed to: {os.getcwd()}", file=sys.stderr)
            # Print ONLY the path to STDOUT for 'cd $(...)' to capture
            print(path_to_change_into, file=sys.stdout)
        except Exception as e:
            print(f"Error changing script's CWD: {e}", file=sys.stderr)
    elif user_confirmed_ok and not created :
        print_header("There was an error creating folders/files.")

if __name__ == "__main__":
    try:
        main()
    except ImportError as e:
        if "pytz" in str(e):
            print(f"\nError: {e}", file=sys.stderr)
            print("The 'pytz' module is required but not found.", file=sys.stderr)
            print("Please install it by running: pip install pytz", file=sys.stderr)
            sys.exit(1)
        else:
            raise
    except Exception as e:
        print(f"An unexpected error occurred: {e}", file=sys.stderr)
        sys.exit(1)
