import os

def load_problem_names(file_path):
    """
    list.txt 파일에서 문제 이름을 불러와서 사전으로 반환합니다.
    키는 문제 번호이며, 값은 전체 문제 이름입니다.
    """
    problem_names = {}
    with open(file_path, 'r', encoding='utf-8') as file:
        for line in file:
            line = line.strip()
            if line:
                parts = line.split('_')
                category = parts[0]  # 문제 카테고리 (예: BOJ, SWEA)
                number = parts[1]  # 문제 번호
                name = '_'.join(parts)  # 전체 문제 이름
                problem_names[number] = name
    return problem_names

def rename_folders(root_dir, problem_names):
    """
    BOJ와 SWEA 디렉토리에서 폴더 이름이 problem_names 사전에 있는 문제 번호와 일치하면
    해당 폴더의 이름을 전체 문제 이름으로 변경합니다.
    """
    for dirpath, dirnames, filenames in os.walk(root_dir):
        # 현재 디렉토리가 BOJ 또는 SWEA인지 확인
        if os.path.basename(dirpath) in ['BOJ', 'SWEA']:
            for dirname in dirnames:
                # 디렉토리 이름이 4자리 또는 5자리 숫자인지 확인
                if dirname.isdigit() and len(dirname) in [4, 5]:
                    problem_number = dirname
                    if problem_number in problem_names:
                        new_dirname = problem_names[problem_number]  # 새로운 디렉토리 이름 설정
                        old_path = os.path.join(dirpath, dirname)
                        new_path = os.path.join(dirpath, new_dirname)
                        os.rename(old_path, new_path)  # 디렉토리 이름 변경
                        print(f'Renamed: {old_path} -> {new_path}')  # 변경된 내용을 출력

if __name__ == "__main__":
    root_directory = r"C:\Users\SSAFY\Documents\GitHub\AlgorithmStudy"
    list_file_path = os.path.join(root_directory, "list.txt")
    
    # list.txt 파일에서 문제 이름을 불러옴
    problem_names_dict = load_problem_names(list_file_path)
    
    # 문제 이름에 따라 폴더 이름을 변경
    rename_folders(root_directory, problem_names_dict)