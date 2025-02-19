import pygame
import random

# 게임 설정
WIDTH, HEIGHT = 800, 600
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
BLUE = (0, 0, 255)

# 초기화
pygame.init()
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Galaga Clone")
clock = pygame.time.Clock()

# 플레이어 설정
player_rect = pygame.Rect(WIDTH // 2 - 25, HEIGHT - 50, 50, 30)
player_speed = 5

# 적 설정
enemies = []
enemy_speed = 2
for _ in range(5):
    enemy_rect = pygame.Rect(random.randint(0, WIDTH - 50), random.randint(-150, -50), 40, 30)
    enemies.append(enemy_rect)

# 총알 설정
bullets = []
bullet_speed = -5

# 점수 설정
score = 0
font = pygame.font.Font(None, 36)

def draw_text(text, pos, color=WHITE):
    render = font.render(text, True, color)
    screen.blit(render, pos)

# 게임 루프
running = True
while running:
    screen.fill(BLACK)
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # 플레이어 이동
    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT] and player_rect.left > 0:
        player_rect.x -= player_speed
    if keys[pygame.K_RIGHT] and player_rect.right < WIDTH:
        player_rect.x += player_speed
    if keys[pygame.K_SPACE]:
        bullet_rect = pygame.Rect(player_rect.centerx - 2, player_rect.top, 5, 15)
        bullets.append(bullet_rect)
    
    # 총알 이동
    for bullet in bullets[:]:
        bullet.y += bullet_speed
        if bullet.bottom < 0:
            bullets.remove(bullet)

    # 적 이동
    for enemy in enemies:
        enemy.y += enemy_speed
        if enemy.top > HEIGHT:
            enemy.y = random.randint(-100, -40)
            enemy.x = random.randint(0, WIDTH - 50)

    # 충돌 감지
    for bullet in bullets[:]:
        for enemy in enemies[:]:
            if bullet.colliderect(enemy):
                bullets.remove(bullet)
                enemies.remove(enemy)
                enemies.append(pygame.Rect(random.randint(0, WIDTH - 50), random.randint(-150, -50), 40, 30))
                score += 10
                break
    
    # 화면에 그리기
    pygame.draw.rect(screen, BLUE, player_rect)
    for enemy in enemies:
        pygame.draw.rect(screen, RED, enemy)
    for bullet in bullets:
        pygame.draw.rect(screen, WHITE, bullet)
    
    # 점수 표시
    draw_text(f"Score: {score}", (10, 10))
    
    pygame.display.flip()
    clock.tick(60)

pygame.quit()
