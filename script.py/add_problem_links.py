import os

# 파일 경로 설정
readme_path = r"C:\Users\SSAFY\Documents\GitHub\AlgorithmStudy\README.md"
list_path = r"C:\Users\SSAFY\Documents\GitHub\AlgorithmStudy\list.md"

# list.md 파일을 읽어와서 링크를 사전에 저장
link_dict = {}
with open(list_path, 'r', encoding='utf-8') as list_file:
    for line in list_file:
        if line.startswith("["):
            # 문제 이름과 링크 추출
            start_idx = line.index("[") + 1
            end_idx = line.index("]")
            problem_name = line[start_idx:end_idx]

            start_link_idx = line.index("(") + 1
            end_link_idx = line.index(")")
            link = line[start_link_idx:end_link_idx]

            link_dict[problem_name] = link

# README.md 파일을 읽어와서 사전의 링크로 업데이트
updated_lines = []
with open(readme_path, 'r', encoding='utf-8') as readme_file:
    for line in readme_file:
        updated_line = line
        for problem_name, link in link_dict.items():
            if problem_name in line:
                # 문제 이름을 HTML <a> 링크로 교체
                updated_line = line.replace(problem_name, f'<a href="{link}">{problem_name}</a>')
        updated_lines.append(updated_line)

# 업데이트된 내용을 README.md 파일에 다시 씀
with open(readme_path, 'w', encoding='utf-8') as readme_file:
    readme_file.writelines(updated_lines)

print("README.md 파일이 링크로 업데이트되었습니다.")