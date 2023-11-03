import com.example.cleanarchitecture.data.datasource.IDataSource
import com.example.cleanarchitecture.data.datasource.RemoteDataSource
import com.example.cleanarchitecture.data.repo.PhoneRepositoryImp
import com.example.cleanarchitecture.domain.IPhoneRepository
import com.example.cleanarchitecture.domain.PhoneUseCase
import com.example.cleanarchitecture.presentation.ui.PhoneViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuele = module {
    single<IDataSource> { RemoteDataSource() }
    single<IPhoneRepository> { PhoneRepositoryImp(dataSource = get()) }
    single<PhoneUseCase> { PhoneUseCase(phoneRepo = get()) }
}
val viewModels = module {
    viewModel { PhoneViewModel(phoneUseCase = get()) } //in koin it will automatically get this
}