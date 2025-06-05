// Tema claro/escuro
    document.addEventListener('DOMContentLoaded', function() {
        const themeToggle = document.querySelector('.theme-toggle');
        const html = document.documentElement;

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

        // Filtro e busca
        const searchInput = document.getElementById('searchInput');
        const searchButton = document.getElementById('searchButton');
        const filterSelect = document.getElementById('filterSelect');
        const tasksContainer = document.getElementById('tasksContainer');

        function filterTasks() {
            const searchTerm = searchInput.value.toLowerCase();
            const filterValue = filterSelect.value;

            document.querySelectorAll('.task-card').forEach(card => {
                const title = card.querySelector('.card-title').textContent.toLowerCase();
                const description = card.querySelector('.card-text').textContent.toLowerCase();
                const isCompleted = card.dataset.completed === 'true';

                const matchesSearch = title.includes(searchTerm) || description.includes(searchTerm);

                let matchesFilter = true;
                if (filterValue === 'completed') {
                    matchesFilter = isCompleted;
                } else if (filterValue === 'pending') {
                    matchesFilter = !isCompleted;
                }

                card.style.display = (matchesSearch && matchesFilter) ? 'block' : 'none';
            });
        }


        filterTasks();

        searchInput.addEventListener('input', filterTasks);
        searchButton.addEventListener('click', filterTasks);
        filterSelect.addEventListener('change', filterTasks);


        let taskIdToDelete = null;
        const confirmModal = new bootstrap.Modal(document.getElementById('confirmModal'));

        window.confirmDelete = function(id) {
            taskIdToDelete = id;
            confirmModal.show();
        };

        document.getElementById('confirmDeleteButton').addEventListener('click', function() {
            if (taskIdToDelete) {
                window.location.href = '/tarefas/excluir/' + taskIdToDelete;
            }
        });

        window.toggleTaskStatus = function(id) {
            fetch('/tarefas/toggle-status/' + id, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                }
            }).then(response => {
                if (response.ok) {
                    window.location.reload();
                } else {
                    console.error('Erro ao alternar status da tarefa.');
                }
            }).catch(error => {
                console.error('Erro na requisição:', error);
            });
        };
    });