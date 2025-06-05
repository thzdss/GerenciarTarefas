  // Tema claro/escuro
  document.addEventListener('DOMContentLoaded', function() {
      const themeToggle = document.querySelector('.theme-toggle');
      const html = document.documentElement;

      // Verifica preferência do usuário ou usa light como padrão
      const savedTheme = localStorage.getItem('theme') || 'light';
      html.setAttribute('data-bs-theme', savedTheme);
      updateThemeIcon(savedTheme);

      themeToggle.addEventListener('click', function() {
          const currentTheme = html.getAttribute('data-bs-theme');
          const newTheme = currentTheme === 'light' ? 'dark' : 'light';
          html.setAttribute('data-bs-theme', newTheme);
          localStorage.setItem('theme', newTheme);
          updateThemeIcon(newTheme);
      });

      function updateThemeIcon(theme) {
          const icon = themeToggle.querySelector('i');
          icon.className = theme === 'light' ? 'bi bi-moon-stars' : 'bi bi-sun';
      }
  });