import SwiftUI
import shared

struct ContentView: View {
    
    @State private var shouldOpenAbout = false
    @State private var shouldOpenSources = false

    var body: some View {
        let articlesScreen = ArticlesScreen(viewModel: .init())
        NavigationStack{
            articlesScreen.toolbar{
                ToolbarItem{
                    Button{
                        shouldOpenAbout = true
                    } label: {
                        Label("About", systemImage: "info.circle").labelStyle(.automatic)
                    }.popover(isPresented: $shouldOpenAbout){
                        AboutScreen()
                    }
                }
                ToolbarItem{
                    Button{
                        shouldOpenSources = true
                    } label: {
                        Label("Source", systemImage: "menucard.fill").labelStyle(.iconOnly)
                    }.popover(isPresented: $shouldOpenSources){
                        SourceScreen()
                    }
                }
            }
        }.refreshable {
            articlesScreen.viewModel.fetchArticles(forceFetch: true)
        }
       
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
