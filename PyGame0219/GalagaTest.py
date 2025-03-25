import pygame
import random

# 초기화
pygame.init()

# 화면 크기 설정
WIDTH, HEIGHT = 600, 800
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Galaga Game")

# 색상
WHITE = (255, 255, 255)
RED = (255, 0, 0)
BLUE = (0, 0, 255)
GREEN = (0, 255, 0)
CYAN = (0, 255, 255)

# 폰트 설정
font = pygame.font.Font(None, 36)

# 플레이어 설정
player_x = WIDTH // 2
player_y = HEIGHT - 100
player_speed = 15
player_size = 50
player_health = 3  # 플레이어 체력 추가

# 적 설정
enemy_size = 50
enemy_kill_count = 0
boss_kill_count = 0
stage = 1  # 스테이지 변수 추가
enemy_speed = 1  # 적 이동 속도 증가 변수
enemies = [[random.randint(0, WIDTH - 50), random.randint(50, 300)] for _ in range(10)]

# 총알 설정
bullets = []
bullet_speed = 10
bullet_size = 5

# 보스 설정
boss = None
boss_size = 100
boss_health = 10
boss_speed = 3

# 게임 종료 변수
game_over = False

# 게임 루프
running = True
while running:
    pygame.time.delay(30)
    screen.fill((0, 0, 0))

    # 이벤트 처리
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_x and pygame.key.get_mods() & pygame.KMOD_CTRL:
                running = False

    if not game_over:
        # 키 입력 처리
        keys = pygame.key.get_pressed()
        if keys[pygame.K_LEFT] and player_x > 0:
            player_x -= player_speed
        if keys[pygame.K_RIGHT] and player_x < WIDTH:
            player_x += player_speed
        if keys[pygame.K_SPACE] and len(bullets) < 100:
            bullets.append([player_x, player_y])

        # 총알 이동
        bullets = [[b[0], b[1] - bullet_speed] for b in bullets if b[1] > 0]

        # 적 이동
        if enemy_kill_count < 30:
            for enemy in enemies:
                enemy[1] += enemy_speed
                if enemy[1] > HEIGHT:
                    enemy[1] = random.randint(50, 300)
                    enemy[0] = random.randint(0, WIDTH - enemy_size)
                
                # 적과 플레이어 충돌 체크
                if (player_x - player_size // 2 < enemy[0] < player_x + player_size // 2) and (
                    player_y - player_size < enemy[1] < player_y + player_size
                ):
                    player_health -= 1  # 체력 감소
                    enemies.remove(enemy)
                    if player_health <= 0:
                        game_over = True

        # 적과 총알 충돌 검사
        new_enemies = []
        for enemy in enemies:
            hit = False
            for bullet in bullets:
                if enemy[0] < bullet[0] < enemy[0] + enemy_size and enemy[1] < bullet[1] < enemy[1] + enemy_size:
                    hit = True
                    enemy_kill_count += 1
                    break
            if not hit:
                new_enemies.append(enemy)

        while len(new_enemies) < 10 and enemy_kill_count < 30:
            new_enemies.append([random.randint(0, WIDTH - enemy_size), random.randint(50, 300)])

        enemies = new_enemies
        bullets = [b for b in bullets if not any(enemy[0] < b[0] < enemy[0] + enemy_size and enemy[1] < b[1] < enemy[1] + enemy_size for enemy in enemies)]

        # 보스 등장 조건
        if enemy_kill_count >= 30 and boss is None:
            boss = [WIDTH // 2 - boss_size // 2, 50]
            boss_health = 50
            enemies = []

        # 보스 이동 및 충돌 검사
        if boss:
            boss[0] += boss_speed
            if boss[0] <= 0 or boss[0] + boss_size >= WIDTH:
                boss_speed *= -1

            # 보스와 총알 충돌 검사
            new_bullets = []
            for bullet in bullets:
                if boss[0] < bullet[0] < boss[0] + boss_size and boss[1] < bullet[1] < boss[1] + boss_size:
                    boss_health -= 1
                else:
                    new_bullets.append(bullet)
            bullets = new_bullets

            # 보스와 플레이어 충돌 체크
            if (player_x - player_size // 2 < boss[0] < player_x + player_size // 2) and (
                player_y - player_size < boss[1] < player_y + player_size
            ):
                player_health -= 1  # 체력 감소
                if player_health <= 0:
                    game_over = True

            if boss_health <= 0:
                boss = None
                boss_kill_count += 1
                enemy_kill_count = 0
                enemies = [[random.randint(0, WIDTH - enemy_size), random.randint(50, 300)] for _ in range(10)]
                if boss_kill_count % 1 == 0:
                    stage += 1
                    enemy_speed += 2

        # 화면에 그리기
        pygame.draw.polygon(screen, BLUE, [(player_x, player_y), (player_x - player_size // 2, player_y + player_size), (player_x + player_size // 2, player_y + player_size)])

        if enemy_kill_count < 30:
            for enemy in enemies:
                pygame.draw.rect(screen, RED, (enemy[0], enemy[1], enemy_size, enemy_size))

        for bullet in bullets:
            pygame.draw.rect(screen, CYAN, (bullet[0], bullet[1], bullet_size, bullet_size))

        if boss:
            pygame.draw.rect(screen, GREEN, (boss[0], boss[1], boss_size, boss_size))
            boss_health_text = font.render(f"Boss HP: {boss_health}", True, WHITE)
            screen.blit(boss_health_text, (10, 50))

        health_text = font.render(f"PlayerHealth: {player_health}", True, WHITE)
        screen.blit(health_text, (10, 30))
        score_text = font.render(f"Stage: {stage} | Enemies Killed: {enemy_kill_count} | Bosses Killed: {boss_kill_count}", True, WHITE)
        screen.blit(score_text, (10, 10))
    else:
        font_large = pygame.font.Font(None, 74)
        text = font_large.render("Game Over", True, WHITE)
        screen.blit(text, (WIDTH // 2 - 100, HEIGHT // 2 - 50))

    pygame.display.update()

pygame.quit()
